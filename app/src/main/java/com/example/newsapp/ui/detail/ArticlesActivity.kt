package com.example.newsapp.ui.detail

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.adapter.ArticlesAdapter
import com.example.newsapp.service.network.model.articles.ArticlesItem
import kotlinx.android.synthetic.main.activity_articles.*
import org.jetbrains.anko.contentView
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.indeterminateProgressDialog
import org.koin.android.viewmodel.ext.android.viewModel

class ArticlesActivity : AppCompatActivity() {
    private val articlesViewModel : ArticlesViewModel by viewModel()
    private var id : String? = null
    private lateinit var dialog : ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)

        id = intent.getStringExtra("id")
        val name = intent.getStringExtra("name")
        setSupportActionBar(toolbar_article)
        supportActionBar?.title = "Articles List $name"

        dialog = indeterminateProgressDialog(message = "Please wait a bit…", title = "Fetching data")
        dialog.setCancelable(false)
        dialog.show()

        getData("a")
        initSearchView()
    }

    private fun initSearchView() {
        search_articles.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query?.length!! > 0){
                    getData(query.toString())
                }else{
                    getData("a")
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })
    }

    private fun getData(q: String) {
        articlesViewModel.getArticlesList(id,q).observe(this, Observer {
            dialog.dismiss()
            if (it.articles?.size != null){
                setAdapter(it.articles)
            }else{
                setError("No Data Found")
            }
        })
    }

    private fun setAdapter(articles: List<ArticlesItem>?) {
        rv_article.layoutManager = LinearLayoutManager(this)
        val adapter = ArticlesAdapter()
        articles?.let { it1 -> adapter.addArticles(it1) }
        rv_article.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    fun setError(msg : String){
        contentView?.snackbar(msg)
    }
}

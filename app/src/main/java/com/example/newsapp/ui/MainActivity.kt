package com.example.newsapp.ui

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.adapter.SourceAdapter
import com.example.newsapp.ui.detail.ArticlesActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.startActivity
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    val mainViewModel : MainViewModel by viewModel()
    private lateinit var dialog : ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        dialog = indeterminateProgressDialog(message = "Please wait a bit…", title = "Fetching data")
        dialog.setCancelable(false)
        dialog.show()

        mainViewModel.getNewsList().observe(this, Observer {
            dialog.dismiss()
            rv_news.layoutManager = LinearLayoutManager(this)
            rv_news.adapter = SourceAdapter(it.sources) {
                startActivity<ArticlesActivity>("id" to it.id, "name" to it.name)
            }
        })
    }

}

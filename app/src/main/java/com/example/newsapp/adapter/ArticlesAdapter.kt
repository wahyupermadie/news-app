package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.databinding.ArticlesItemBinding
import com.example.newsapp.service.network.model.articles.ArticlesItem

class ArticlesAdapter : RecyclerView.Adapter<ArticlesAdapter.ViewHolder>(){
    private var articles : List<ArticlesItem>? = arrayListOf()

    fun addArticles(data : List<ArticlesItem>){
        articles = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ArticlesItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.articles_item, parent, false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if(articles?.size == null) 0 else articles!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.article.articles = articles?.get(position)
    }

    class ViewHolder(val article : ArticlesItemBinding) : RecyclerView.ViewHolder(article.root) {

    }
}
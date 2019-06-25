package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.databinding.NewsItemBinding
import com.example.newsapp.service.network.model.SourcesItem

class SourceAdapter(private var source : List<SourcesItem>?) : RecyclerView.Adapter<SourceAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<NewsItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.news_item, parent, false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (source?.size == null) 0 else source!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.source.news = source?.get(position)
    }

    class ViewHolder(val source : NewsItemBinding) : RecyclerView.ViewHolder(source.root)
}
package com.example.newsapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.service.network.ApiService
import com.example.newsapp.service.network.model.articles.ResponseArticles
import com.example.newsapp.service.network.repository.NewsRepository
import com.example.newsapp.utils.AppSchedulerProvider
import com.example.newsapp.utils.SchedulerProvider

class ArticlesViewModel(apiService: ApiService) : ViewModel(){
    private var scheduler : SchedulerProvider = AppSchedulerProvider()
    val repository = NewsRepository(apiService, scheduler)

    fun getArticlesList(id : String?, q : String) : LiveData<ResponseArticles> {
        return repository.getArticles(id, q)
    }

}
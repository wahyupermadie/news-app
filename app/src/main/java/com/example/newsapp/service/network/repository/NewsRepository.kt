package com.example.newsapp.service.network.repository

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.service.network.ApiService
import com.example.newsapp.service.network.model.ResponseNews
import com.example.newsapp.service.network.model.articles.ResponseArticles
import com.example.newsapp.utils.Constant
import com.example.newsapp.utils.SchedulerProvider

class NewsRepository(private val apiService: ApiService?, private var scheduler : SchedulerProvider){
    val news = MutableLiveData<ResponseNews>()
    val articles = MutableLiveData<ResponseArticles>()

    @SuppressLint("CheckResult")
    fun getNewsList() : LiveData<ResponseNews>{
        apiService?.getSource(Constant.API_KEY, Constant.LANGUAGE, Constant.COUNTRY)
            ?.observeOn(scheduler.ui())
            ?.subscribeOn(scheduler.io())
            ?.subscribe({
                news.value = it
            },{
                news.value = null
            })
        return news
    }

    @SuppressLint("CheckResult")
    fun getArticles(id : String?, q : String) : LiveData<ResponseArticles>{
        apiService?.getArticles(Constant.API_KEY, id,q)
            ?.observeOn(scheduler.ui())
            ?.subscribeOn(scheduler.io())
            ?.subscribe({
                articles.value = it
            },{
                articles.value = null
            })
        return articles
    }
}
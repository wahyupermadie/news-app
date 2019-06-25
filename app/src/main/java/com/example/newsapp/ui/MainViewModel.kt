package com.example.newsapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.service.network.ApiService
import com.example.newsapp.service.network.model.ResponseNews
import com.example.newsapp.service.network.model.SourcesItem
import com.example.newsapp.service.network.repository.NewsRepository
import com.example.newsapp.utils.AppSchedulerProvider
import com.example.newsapp.utils.SchedulerProvider

class MainViewModel(apiService: ApiService) : ViewModel(){
    private var scheduler : SchedulerProvider = AppSchedulerProvider()
    val repository = NewsRepository(apiService, scheduler)

    fun getNewsList() : LiveData<ResponseNews>{
        return repository.getNewsList()
    }

    fun onShowData(item : String){
        Log.d("DATA_DATA","DATA "+item)
    }
}
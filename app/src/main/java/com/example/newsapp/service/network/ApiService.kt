package com.example.newsapp.service.network

import com.example.newsapp.service.network.model.ResponseNews
import com.example.newsapp.service.network.model.articles.ResponseArticles
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("everything")
    fun getArticles(@Query("apiKey") key : String,
                    @Query("source") source: String) : Flowable<ResponseArticles>

    @GET("sources")
    fun getSource(@Query("apiKey") key : String,
                  @Query("language") language: String,
                  @Query("country") country: String) : Flowable<ResponseNews>


}
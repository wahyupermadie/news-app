package com.example.newsapp.service.network.model.articles
import com.google.gson.annotations.SerializedName
data class ResponseArticles(

	@field:SerializedName("totalResults")
	val totalResults: Int? = null,

	@field:SerializedName("articles")
	val articles: List<ArticlesItem>? = null,

	@field:SerializedName("status")
	val status: String? = null
)
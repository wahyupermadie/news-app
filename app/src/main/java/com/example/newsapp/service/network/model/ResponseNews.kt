package com.example.newsapp.service.network.model
import com.google.gson.annotations.SerializedName
data class ResponseNews(

	@field:SerializedName("sources")
	val sources: List<SourcesItem>? = null,

	@field:SerializedName("status")
	val status: String? = null
)
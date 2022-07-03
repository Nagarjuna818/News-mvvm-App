package com.example.newsappmvvm.data.repositories

import retrofit2.Call
import com.example.newsappmvvm.data.models.NewsResponse
import com.example.newsappmvvm.data.network.MyApi

class NewsRepository (
    private val api: MyApi
) {

    fun getNews(country: String, category: String, apiKey: String): Call<NewsResponse> {
        return api.getNews(country, category, apiKey)
    }
}
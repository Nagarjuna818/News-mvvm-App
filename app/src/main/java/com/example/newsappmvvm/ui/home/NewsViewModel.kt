package com.example.newsappmvvm.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsappmvvm.app.Config
import com.example.newsappmvvm.data.models.NewsResponse
import com.example.newsappmvvm.data.network.MyApi
import com.example.newsappmvvm.data.repositories.NewsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel (): ViewModel() {

    var newsResponseLiveData: MutableLiveData<NewsResponse>? = null

    fun getNews(): MutableLiveData<NewsResponse> {
        newsResponseLiveData = MutableLiveData()
        var country = "us"
        var category = "business"

        var repository = NewsRepository(MyApi())
        repository.getNews(country, category, Config.API_KEY)
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    var data = response.body()
                    newsResponseLiveData?.value = data

                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.d("abc", t.message.toString())
                }

            })
        return newsResponseLiveData!!
    }
}

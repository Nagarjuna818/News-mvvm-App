package com.example.newsappmvvm.data.models

import java.io.Serializable


data class NewsResponse(
    val articles: ArrayList<Article>? = null,
    val status: String? = null,
    val totalResults: Int? = null
)

data class Article(
    val author: String? = null,
    val content: String? = null,
    val description: String? = null,
    val publishedAt: String? = null,
    val source: Source? = null,
    val title: String? = null,
    val url: String? = null,
    val urlToImage: String? = null
):Serializable {
    companion object {
        const val KEY_ARTICLE = "article"
    }
}

data class Source(
    val id: String,
    val name: String
)
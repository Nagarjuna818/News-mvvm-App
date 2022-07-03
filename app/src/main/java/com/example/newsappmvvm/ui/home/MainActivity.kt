package com.example.newsappmvvm.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappmvvm.R
import com.example.newsappmvvm.adapters.ArticleAdapter
import com.example.newsappmvvm.data.models.Article
import com.example.newsappmvvm.data.models.NewsResponse
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var articleAdapter: ArticleAdapter
    var mlist : ArrayList<Article> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        articleAdapter = ArticleAdapter(this)
        init()
    }

    private fun init() {
        var myViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        var liveData =  myViewModel.getNews()

        recycler_view.adapter = articleAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)

        liveData.observe(this, object: Observer<NewsResponse> {
            override fun onChanged(t: NewsResponse?) {
                progress_bar.visibility = View.GONE
                mlist = t!!.articles!!
                articleAdapter.setData(t.articles!!)
            }
        })
    }
}
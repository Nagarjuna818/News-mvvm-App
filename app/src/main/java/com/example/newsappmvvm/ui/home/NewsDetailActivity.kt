package com.example.newsappmvvm.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsappmvvm.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_news_detail.*

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        var title = intent.getStringExtra("title")
        text_view_title.text =title
        text_view_desc.text = intent.getStringExtra("description")
        text_view_author.text = intent.getStringExtra("author")

        Picasso
            .get().load(intent.getStringExtra("image"))
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .into(image_view)

        button_back.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}
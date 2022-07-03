package com.example.newsappmvvm.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappmvvm.R
import com.example.newsappmvvm.data.models.Article
import com.example.newsappmvvm.ui.home.NewsDetailActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.single_row_adapter.view.*

class ArticleAdapter (var mContext: Context?): RecyclerView.Adapter<ArticleAdapter.ViewHolder>(){

    var mList: ArrayList<Article> = ArrayList()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(article: Article){

            itemView.text_view_title.text = article.title

            Picasso
                .get().load(article.urlToImage)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(itemView.image_view)

            itemView.card_view.setOnClickListener {
                var intent = Intent(mContext, NewsDetailActivity::class.java)
                intent.putExtra("title",article.title)
                intent.putExtra("description",article.content)
                intent.putExtra("image",article.urlToImage)
                intent.putExtra("author",article.author)
                mContext?.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(mContext).inflate(R.layout.single_row_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var comment = mList[position]
        holder.bind(comment)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setData(list: ArrayList<Article>) {
        mList = list
        notifyDataSetChanged()
    }
}
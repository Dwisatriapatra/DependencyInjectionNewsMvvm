package com.example.dependencyinjectionnewsmvvm.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dependencyinjectionnewsmvvm.R
import com.example.dependencyinjectionnewsmvvm.model.GetAllNewsResponseItem
import kotlinx.android.synthetic.main.item_news_adapter.view.*

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.ViewHolder>(){
    private var listNews : List<GetAllNewsResponseItem>? = null

    fun setListNews(list : List<GetAllNewsResponseItem>){
        this.listNews = list
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news_adapter, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        with(holder.itemView){
            with(listNews!![position]){
                card_author.text = "Penulis: \n$author"
                card_title.text = "Judul: \n$title"
                card_created_at.text = "Tanggal terbit: \n$createdAt"
                Glide.with(card_image.context)
                    .load(image)
                    .error(R.drawable.ic_launcher_background)
                    .override(100, 100)
                    .into(card_image)
            }
        }

    }

    override fun getItemCount(): Int {
        return if(listNews.isNullOrEmpty()){
            0
        }else{
            listNews!!.size
        }
    }
}
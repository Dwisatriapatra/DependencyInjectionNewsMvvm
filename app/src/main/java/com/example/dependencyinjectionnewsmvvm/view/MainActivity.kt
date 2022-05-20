package com.example.dependencyinjectionnewsmvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dependencyinjectionnewsmvvm.R
import com.example.dependencyinjectionnewsmvvm.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var adapter : NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        getDataNews()
    }

    fun getDataNews(){
        adapter = NewsAdapter(){
            val clickedNews = Bundle()
            clickedNews.putSerializable("NEWS", it)
            val intent = Intent(this, DetailActivity::class.java).putExtras(clickedNews)
            startActivity(intent)
        }
        rv_news.layoutManager = LinearLayoutManager(this)
        rv_news.adapter = adapter

        val viewModel = ViewModelProvider(this).get(
            NewsViewModel::class.java
        )
        viewModel.news.observe(this){
            if(it.isNotEmpty()){
                adapter.setListNews(it)
                adapter.notifyDataSetChanged()
            }
        }
    }
}
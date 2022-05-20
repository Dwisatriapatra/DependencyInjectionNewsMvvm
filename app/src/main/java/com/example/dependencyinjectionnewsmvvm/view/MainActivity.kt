package com.example.dependencyinjectionnewsmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dependencyinjectionnewsmvvm.R
import com.example.dependencyinjectionnewsmvvm.networking.ApiNewsServices
import com.example.dependencyinjectionnewsmvvm.repository.NewsRepository
import com.example.dependencyinjectionnewsmvvm.viewmodel.NewsViewModel
import com.example.dependencyinjectionnewsmvvm.viewmodel.NewsViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: NewsViewModel
    private lateinit var adapter : NewsAdapter
    private val apiNewsServices = ApiNewsServices.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        getNewsFromViewModel()
    }

    private fun initRecyclerView() {
        rv_news.layoutManager = LinearLayoutManager(this)
        adapter = NewsAdapter()
        rv_news.adapter = adapter
    }

    private fun getNewsFromViewModel() {
        viewModel = ViewModelProvider(this, NewsViewModelFactory(NewsRepository(apiNewsServices))
        ).get(NewsViewModel::class.java)
        viewModel.liveDataNews.observe(this){
            adapter.setListNews(it)
            adapter.notifyDataSetChanged()
        }
        viewModel.getAllNews()
    }
}
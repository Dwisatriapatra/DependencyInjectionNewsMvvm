package com.example.dependencyinjectionnewsmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dependencyinjectionnewsmvvm.model.GetAllNewsResponseItem
import com.example.dependencyinjectionnewsmvvm.repository.NewsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel(private val repo : NewsRepository) : ViewModel() {
    val liveDataNews = MutableLiveData<List<GetAllNewsResponseItem>>()
    fun getAllNews(){
        val response = repo.getAllFilm()
        response.enqueue(object : Callback<List<GetAllNewsResponseItem>> {
            override fun onResponse(
                call: Call<List<GetAllNewsResponseItem>>,
                response: Response<List<GetAllNewsResponseItem>>
            ) {
                liveDataNews.postValue(response.body())
            }

            override fun onFailure(call: Call<List<GetAllNewsResponseItem>>, t: Throwable) {
                //do nothing
            }

        })
    }
}
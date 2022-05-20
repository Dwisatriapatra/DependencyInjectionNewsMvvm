package com.example.dependencyinjectionnewsmvvm.networking

import com.example.dependencyinjectionnewsmvvm.model.GetAllNewsResponseItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiNewsServices {
    @GET("news")
    fun getAllNews() : Call<List<GetAllNewsResponseItem>>

    companion object{
        var apiNewsServices: ApiNewsServices? = null
        fun getInstance(): ApiNewsServices{
            if(apiNewsServices == null){
                val baseUrl = "https://6284f061a48bd3c40b783f73.mockapi.io/"
                val retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                apiNewsServices = retrofit.create(ApiNewsServices::class.java)
            }
            return apiNewsServices!!
        }
    }
}
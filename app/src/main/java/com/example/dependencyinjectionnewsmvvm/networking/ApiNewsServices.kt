package com.example.dependencyinjectionnewsmvvm.networking

import com.example.dependencyinjectionnewsmvvm.model.GetAllNewsResponseItem
import retrofit2.http.GET

interface ApiNewsServices {
    @GET("news")
    suspend fun getAllNews() : List<GetAllNewsResponseItem>
}
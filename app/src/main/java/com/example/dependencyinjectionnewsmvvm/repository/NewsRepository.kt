package com.example.dependencyinjectionnewsmvvm.repository

import com.example.dependencyinjectionnewsmvvm.networking.ApiNewsServices

class NewsRepository constructor(private val apiNewsServices: ApiNewsServices) {
    fun getAllFilm() = apiNewsServices.getAllNews()
}
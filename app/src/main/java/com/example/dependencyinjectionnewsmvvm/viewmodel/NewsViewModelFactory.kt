package com.example.dependencyinjectionnewsmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dependencyinjectionnewsmvvm.repository.NewsRepository

class NewsViewModelFactory  constructor(private val repo : NewsRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(NewsViewModel::class.java)){
            NewsViewModel(this.repo) as T
        }else{
            throw IllegalArgumentException("View model not found")
        }
    }

}
package com.example.dependencyinjectionnewsmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dependencyinjectionnewsmvvm.model.GetAllNewsResponseItem
import com.example.dependencyinjectionnewsmvvm.networking.ApiNewsServices
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(api : ApiNewsServices) : ViewModel() {
    private val liveData = MutableLiveData<List<GetAllNewsResponseItem>>()
    val news : LiveData<List<GetAllNewsResponseItem>> = liveData
    init {
        viewModelScope.launch {
            val datanews = api.getAllNews()
            delay(2000)
            liveData.value = datanews
        }
    }
}
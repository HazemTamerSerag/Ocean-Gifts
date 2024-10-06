package com.example.nasaxml.ui.articles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ArticlesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Soon !! In Next Update!!!"
    }
    val text: LiveData<String> = _text
}
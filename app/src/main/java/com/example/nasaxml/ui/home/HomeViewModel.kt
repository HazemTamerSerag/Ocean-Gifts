package com.example.nasaxml.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Earth isn’t the only ocean world in our solar system. Water on other worlds exists in diverse forms on moons, dwarf planets, and even comets. Ice, water vapor in the atmosphere, and oceans on other worlds offer clues in the quest to discover life beyond our home planet."
    }
    val text: LiveData<String> = _text
}
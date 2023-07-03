package com.example.android_three_tab.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {



    private val _text = MutableLiveData<String>().apply {
        value = "123123123"
    }
    val text: LiveData<String> = _text
}
package com.example.android_three_tab.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.content.Context
import com.example.android_three_tab.R


class NotificationsViewModel(private val context: Context) : ViewModel() {

//    private val _text = MutableLiveData<String>().apply {
//        value = ""
//    }
//    val text: LiveData<String> = _text
    private val _text = MutableLiveData<String>().apply {
        value = context.getString(R.string.bio)
    }
    val text: LiveData<String> = _text
}
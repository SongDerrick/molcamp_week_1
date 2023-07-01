package com.example.android_three_tab.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.android_three_tab.R

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)
        val position = intent.getIntExtra("position", -1)
        // val bundle : Bundle?= intent.extras

        val imageView : ImageView = findViewById(R.id.imageView)
        imageView.setImageResource(position)
    }
}
package com.example.android_three_tab.ui.home

import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.media.MediaScannerConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.android_three_tab.R
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.util.jar.Manifest

class DetailedActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var downloadButton: Button
    private lateinit var imageUrl: String

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PERMISSION_WRITE_EXTERNAL_STORAGE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, proceed with image download
                downloadImage()
            } else {
                // Permission denied, handle accordingly (e.g., show a message)
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)
        val position = intent.getIntExtra("position", -1)


        supportActionBar?.hide()

        imageUrl = intent.data?.toString() ?: ""
        downloadButton = findViewById(R.id.downloadButton)

        imageView = findViewById(R.id.imageView)
        imageView.setImageResource(position)

        val downloadButton: Button = findViewById(R.id.downloadButton)
        downloadButton.setOnClickListener {
            // Check if the WRITE_EXTERNAL_STORAGE permission is granted
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                // Permission is granted, proceed with image download
                downloadImage()
            } else {
                // Permission is not granted, request the permission
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    REQUEST_PERMISSION_WRITE_EXTERNAL_STORAGE
                )
            }
        }
    }

    private fun downloadImage() {
        val drawable = imageView.drawable
        val bitmap = (drawable as BitmapDrawable).bitmap

        val imagesDirectory = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "MyApp")
        imagesDirectory.mkdirs()

        val filename = "image_${System.currentTimeMillis()}.jpg"
        val file = File(imagesDirectory, filename)

        try {
            FileOutputStream(file).use { outputStream ->
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
                outputStream.flush()
            }

            // Notify the Gallery app about the newly added image
            MediaScannerConnection.scanFile(
                this,
                arrayOf(file.absolutePath),
                null,
                null
            )

            Toast.makeText(this, "Image saved to gallery", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "Failed to save image", Toast.LENGTH_SHORT).show()
        }
    }

    private companion object {
        private const val REQUEST_PERMISSION_WRITE_EXTERNAL_STORAGE = 100
    }
}
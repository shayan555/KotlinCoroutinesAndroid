package com.example.kotlincoroutinesandroid

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLoadImage = findViewById<Button>(R.id.btn_load_image)
        val imageView = findViewById<ImageView>(R.id.im_image)

        btnLoadImage.setOnClickListener()
        {
            CoroutineScope(Dispatchers.IO).launch {
                Log.d("MyTag", "onCreate: ThreadName: ${Thread.currentThread().name}")  //Worker Thread
                val url = URL("https://i.redd.it/bfc0pz8qdji61.jpg")
                val bitmap = BitmapFactory.decodeStream(url.openStream())
                withContext(Dispatchers.Main)
                {
                    Log.d("MyTag", "onCreate: ThreadName: ${Thread.currentThread().name}")  //Main Thread
                    imageView.setImageBitmap(bitmap)
                }

            }
        }

    }
}
package com.example.hw3

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import com.example.hw3.databinding.ActivityWithoutLibrariesBinding
import java.lang.Exception
import java.util.concurrent.Executors

private lateinit var binding: ActivityWithoutLibrariesBinding

class WithoutLibrariesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWithoutLibrariesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        var image: Bitmap?

        binding.getImageButton.setOnClickListener {
            executor.execute {
                try {
                    val inputStream = java.net.URL(binding.editTextImageUrl.text.toString()).openStream()
                    image = BitmapFactory.decodeStream(inputStream)

                    handler.post {
                        binding.imageView.visibility = View.VISIBLE
                        binding.imageView.setImageBitmap(image)
                    }
                } catch (e: Exception) {
                    Toast.makeText(
                        this,
                        "Ошибка загрузки изображения!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
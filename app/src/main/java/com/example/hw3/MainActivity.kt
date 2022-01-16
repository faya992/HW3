package com.example.hw3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.glideButton.setOnClickListener {
            startActivity(Intent(this, GlideActivity::class.java))
        }
        binding.withoutLibrariesButton.setOnClickListener {
            startActivity(Intent(this, WithoutLibrariesActivity::class.java))
        }
    }
}
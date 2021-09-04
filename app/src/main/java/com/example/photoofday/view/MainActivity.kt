package com.example.photoofday.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoofday.R
import com.example.photoofday.databinding.MainActivitiBinding




class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivitiBinding

    private val fragmentPictureOfTheDay by lazy { PictureOfTheDayFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivitiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragmentPictureOfTheDay)
            .commit()
    }
}
package com.example.PhotoOfDay.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.PhotoOfDay.databinding.ActivitySplashBinding

//из SplashActivity завпускается основной экран MainActivity
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //анимация вращения нашей иконки
        binding.imageView.animate().rotationBy(750f)
            .setInterpolator(LinearInterpolator()).duration = 6000

        handler.postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }, 3000)
    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }
}
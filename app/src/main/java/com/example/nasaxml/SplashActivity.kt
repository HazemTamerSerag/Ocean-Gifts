package com.example.nasaxml

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.nasaxml.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hide the title bar if necessary
        supportActionBar?.hide()

        // Inflate layout using data binding
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Start fade-in animation for the NASA image
        binding.nasaImage.animate()
            .alpha(1f)
            .setDuration(1500)
            .withEndAction {
                Handler(Looper.getMainLooper()).postDelayed({
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }, 2000L)
            }
            .start()
    }
}
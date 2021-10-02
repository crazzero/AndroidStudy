package com.kwang0.deeplink

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kwang0.deeplink.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)

        binding.textMain.text = intent.extras?.getString("Deep Link", "Not Worked!!")
    }
}
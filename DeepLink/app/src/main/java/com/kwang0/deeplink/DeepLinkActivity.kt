package com.kwang0.deeplink

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DeepLinkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Intent(this, MainActivity::class.java)
            .also {
                it.putExtra("Deep Link", "worked!!")
                startActivity(it)
                finish()
            }
    }
}
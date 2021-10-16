package com.kwang0.androidwisywig.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.kwang0.androidwisywig.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.moveToWasa).setOnClickListener {
            startActivity(Intent(this, WasaActivity::class.java))
        }
        findViewById<Button>(R.id.moveToIrshu).setOnClickListener {
            startActivity(Intent(this, IrshuActivity::class.java))
        }
        findViewById<Button>(R.id.moveToOneCode).setOnClickListener {
            startActivity(Intent(this, OneCodeActivity::class.java))
        }
        findViewById<Button>(R.id.moveToCustom).setOnClickListener {
            startActivity(Intent(this, CustomActivity::class.java))
        }
    }
}

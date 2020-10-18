package com.kwang0.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class NavigationActivity : AppCompatActivity() {

    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutId)

        // init
        initActivity()
    }

    abstract fun initActivity()

    fun getNavigation() {
        return
    }
}

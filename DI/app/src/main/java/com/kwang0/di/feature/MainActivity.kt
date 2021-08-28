package com.kwang0.di.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kwang0.di.R
import com.kwang0.di.SomeClass
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

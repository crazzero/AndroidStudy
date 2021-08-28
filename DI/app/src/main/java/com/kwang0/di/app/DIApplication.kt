package com.kwang0.di.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DIApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        //...
    }
}

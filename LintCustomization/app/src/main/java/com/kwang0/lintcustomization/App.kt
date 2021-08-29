package com.kwang0.lintcustomization

import android.app.Application
import androidx.work.Configuration

class App : Application(), Configuration.Provider {
    override fun getWorkManagerConfiguration() = Configuration.Builder().build()
}

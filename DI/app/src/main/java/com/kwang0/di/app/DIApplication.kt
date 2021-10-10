package com.kwang0.di.app

import android.app.Application
import com.kwang0.di.data.secondRepositoryModule
import com.kwang0.di.feature.secondActivityModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@HiltAndroidApp
class DIApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        //...

        // Start koin container
        startKoin {
            // Koin Android logger
            androidLogger()
            //inject Android context
            androidContext(this@DIApplication)
            // Start modules
            modules(
//                // Start module
//                module {
//                    // Singleton
//                    single {  }
//                    // Factory
//                    factory {  }
//                }
//                // End module

                *modules
            )
            // End modules
        }
        // End koin container
    }
}

var appModules = arrayOf(
        secondRepositoryModule,
)
var pageModules = arrayOf(
        secondActivityModule,
)

val modules = arrayOf(
    *appModules,
    *pageModules,
)

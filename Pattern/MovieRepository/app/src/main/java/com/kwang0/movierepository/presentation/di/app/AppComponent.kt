package com.kwang0.movierepository.presentation.di.app

import android.app.Application
import com.kwang0.movierepository.MoviesApp
import com.kwang0.movierepository.presentation.di.ActivityBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBuilder::class])
interface AppComponent: AndroidInjector<MoviesApp> {

    override fun inject(app: MoviesApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

}

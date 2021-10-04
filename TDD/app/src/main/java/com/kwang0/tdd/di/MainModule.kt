package com.kwang0.tdd.di

import android.app.Activity
import com.kwang0.tdd.presentation.MainActivity
import com.kwang0.tdd.presentation.MainContract
import com.kwang0.tdd.presentation.MainPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class MainModule{

    @Binds
    abstract fun bindActivity(view: MainActivity): MainContract.View

    @Binds
    abstract fun bindPresenter(impl: MainPresenter): MainContract.Presenter

}

@Module
@InstallIn(ActivityComponent::class)
object MainActivityModule{

    @Provides
    fun bindMainActivity(activity: Activity): MainActivity {
        return activity as MainActivity
    }
}

package com.kwang0.di.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
object TestApiModule {
    @Provides
    fun provideTestApi(): TestApi {
        return Retrofit.Builder().baseUrl("ip_address").build().create(TestApi::class.java)
    }
}

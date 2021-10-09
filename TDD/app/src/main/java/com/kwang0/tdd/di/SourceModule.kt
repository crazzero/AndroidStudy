package com.kwang0.tdd.di

import com.kwang0.tdd.data.local.LocalPreferenceDataSource
import com.kwang0.tdd.data.local.LocalPreferenceDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SourceModule {
    @Binds
    @Singleton
    abstract fun bindLocalPreferenceDataSource(impl: LocalPreferenceDataSourceImpl): LocalPreferenceDataSource
}

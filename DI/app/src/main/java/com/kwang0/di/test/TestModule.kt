package com.kwang0.di.test

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class TestModule {
    @Binds
    abstract fun bindTest(test: TestImpl): Test
}

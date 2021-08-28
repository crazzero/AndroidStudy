package com.kwang0.di.data.api

import javax.inject.Inject

class TestApiClass @Inject constructor(private val testApi: TestApi) {
    suspend fun getSome() {
        testApi.getSome()
    }
}

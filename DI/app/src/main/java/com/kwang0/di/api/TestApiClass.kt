package com.kwang0.di.api

import javax.inject.Inject

class TestClass @Inject constructor(private val testApi: TestApi) {
    suspend fun getSome() {
        testApi.getSome()
    }
}

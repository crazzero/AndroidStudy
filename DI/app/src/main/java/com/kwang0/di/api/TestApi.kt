package com.kwang0.di.api

import com.kwang0.di.entity.SomeEntity
import retrofit2.Response
import retrofit2.http.GET

interface TestApi {
    @GET("/some_url")
    suspend fun getSome() : Response<SomeEntity>
}

package com.kwang0.di.data.api

import com.kwang0.di.data.db.SomeEntity
import retrofit2.Response
import retrofit2.http.GET

interface TestApi {
    @GET("/some_url")
    suspend fun getSome() : Response<SomeEntity>
}

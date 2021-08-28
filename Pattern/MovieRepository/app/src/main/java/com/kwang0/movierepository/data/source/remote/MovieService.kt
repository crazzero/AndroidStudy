package com.kwang0.movierepository.data.source.remote

import com.kwang0.movierepository.data.entity.PageEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
    fun getMovies(@Query("api_key") apiKey: String): Call<PageEntity>

}

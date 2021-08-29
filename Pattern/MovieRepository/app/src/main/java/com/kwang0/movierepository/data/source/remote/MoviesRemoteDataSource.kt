package com.kwang0.movierepository.data.source.remote

import com.kwang0.movierepository.R
import com.kwang0.movierepository.data.entity.MovieEntity
import com.kwang0.movierepository.data.exception.NetworkConnectionException
import com.kwang0.movierepository.data.exception.ServiceException
import com.kwang0.movierepository.utils.ResUtils
import java.io.IOException


interface MoviesRemoteDataSource {

    @Throws(Exception::class)
    fun getMovies(): List<MovieEntity>

}

class MoviesRemoteDataSourceImpl(private val movieService: MovieService): MoviesRemoteDataSource {

    override fun getMovies(): List<MovieEntity> {
        try {
            // You can get api key at (https://developers.themoviedb.org/3/getting-started)
            val response = movieService.getMovies(ResUtils.getString("API_KEY")).execute()
            if(response.isSuccessful){
                return response.body()?.movies ?: emptyList()
            } else{
                throw ServiceException()
            }
        } catch (exception: IOException) {
            throw NetworkConnectionException()
        }
    }

}

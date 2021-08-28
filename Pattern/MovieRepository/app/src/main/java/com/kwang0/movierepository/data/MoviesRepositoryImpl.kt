package com.kwang0.movierepository.data

import com.kwang0.movierepository.data.entity.MovieEntity
import com.kwang0.movierepository.data.entity.mapper.EntityDataMapper
import com.kwang0.movierepository.data.source.local.MoviesLocalDataSource
import com.kwang0.movierepository.data.source.remote.MoviesRemoteDataSource
import com.kwang0.movierepository.domain.Movie
import com.kwang0.movierepository.domain.MoviesRepository

class MoviesRepositoryImpl(
    private val localDataSource: MoviesLocalDataSource,
    private val remoteDataSource: MoviesRemoteDataSource,
    private val entityDataMapper: EntityDataMapper
): MoviesRepository {

    override fun getMovies(onlyOnline: Boolean): List<Movie> {
        var movieEntityList: List<MovieEntity>
        if (onlyOnline) {
            movieEntityList = remoteDataSource.getMovies()
            saveData(movieEntityList)
        } else {
            movieEntityList = localDataSource.getMovies()
            if (movieEntityList.isEmpty()) {
                movieEntityList = remoteDataSource.getMovies()
                saveData(movieEntityList)
            }
        }
        return entityDataMapper.transform(movieEntityList)
    }

    private fun saveData(movieEntityList: List<MovieEntity>) {
        localDataSource.deleteAllMovies()
        localDataSource.saveMovies(movieEntityList)
    }

    override fun getMovie(movieId: Int): Movie {
        return entityDataMapper.transform(localDataSource.getMovie(movieId))!!
    }

}

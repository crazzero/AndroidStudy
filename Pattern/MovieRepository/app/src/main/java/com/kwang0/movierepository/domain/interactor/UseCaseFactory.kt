package com.kwang0.movierepository.domain.interactor

import com.kwang0.movierepository.domain.Movie
import com.kwang0.movierepository.domain.MoviesRepository
import com.kwang0.movierepository.domain.executor.JobScheduler
import com.kwang0.movierepository.domain.executor.UIScheduler
import javax.inject.Inject

class UseCaseFactory @Inject constructor(
    private val repository: MoviesRepository,
    private val uiScheduler: UIScheduler,
    private val jobScheduler: JobScheduler
) {

    fun getMovie(): UseCase<Movie, GetMovie.Params> {
        return GetMovie(repository, uiScheduler, jobScheduler)
    }

    fun getMovies(): UseCase<List<Movie>, GetMovies.Params> {
        return GetMovies(repository, uiScheduler, jobScheduler)
    }

}

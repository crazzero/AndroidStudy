package com.kwang0.movierepository.domain.interactor

import com.kwang0.movierepository.domain.Movie
import com.kwang0.movierepository.domain.MoviesRepository
import com.kwang0.movierepository.domain.executor.JobScheduler
import com.kwang0.movierepository.domain.executor.UIScheduler
import io.reactivex.Single

class GetMovie(
    private val repository: MoviesRepository,
    uiScheduler: UIScheduler,
    jobScheduler: JobScheduler
): UseCase<Movie, GetMovie.Params>(uiScheduler, jobScheduler) {

    override fun buildUseCaseObservable(params: Params): Single<Movie> {
        return Single.just(repository.getMovie(params.movieId))
    }

    class Params(val movieId: Int)
}

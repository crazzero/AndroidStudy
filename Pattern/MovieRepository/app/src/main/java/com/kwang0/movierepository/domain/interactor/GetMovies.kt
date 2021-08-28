package com.kwang0.movierepository.domain.interactor

import com.kwang0.movierepository.domain.Movie
import com.kwang0.movierepository.domain.MoviesRepository
import com.kwang0.movierepository.domain.executor.JobScheduler
import com.kwang0.movierepository.domain.executor.UIScheduler
import io.reactivex.Single

class GetMovies(
    private val repository: MoviesRepository,
    uiScheduler: UIScheduler,
    jobScheduler: JobScheduler
): UseCase<List<Movie>, GetMovies.Params>(uiScheduler, jobScheduler) {

    override fun buildUseCaseObservable(params: Params): Single<List<Movie>> {
        return Single.create { emitter ->
            try {
                val movieList = repository.getMovies(params.isOnlyOnline)
                emitter.onSuccess(movieList)
            } catch (exception: Exception) {
                if (!emitter.isDisposed) {
                    emitter.onError(exception)
                }
            }
        }
    }

    class Params(val isOnlyOnline: Boolean)
}

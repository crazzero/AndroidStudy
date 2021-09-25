package com.kwang0.movierepository.ui.feature.detail

import com.kwang0.movierepository.domain.Movie
import com.kwang0.movierepository.domain.Observer
import com.kwang0.movierepository.domain.interactor.GetMovie
import com.kwang0.movierepository.domain.interactor.UseCaseFactory
import com.kwang0.movierepository.utils.Formatter
import io.reactivex.disposables.CompositeDisposable


class DetailPresenter(
    private val view: DetailContract.View,
    private val useCaseFactory: UseCaseFactory,
    private val formatter: Formatter,
    private val movieId: Int,
): DetailContract.Presenter {

    override val disposables: CompositeDisposable = CompositeDisposable()

    override fun viewReady() {
        val useCase = useCaseFactory.getMovie()
        addDisposable(useCase.execute(MovieObserver(), GetMovie.Params(movieId)))
    }

    private inner class MovieObserver : Observer<Movie>() {
        override fun onSuccess(t: Movie) {
            view.let {
                it.displayImage(formatter.getCompleteUrlImage(t.backdropPath))
                it.displayTitle(t.title)
                it.displayVoteAverage(t.voteAverage)
                it.displayReleaseDate(formatter.formatDate(t.releaseDate))
                it.displayOverview(t.overview)
            }
        }
    }

    override fun navUpSelected() {
        view.goToBack()
    }

}

package com.kwang0.movierepository.ui.feature.main

import com.kwang0.movierepository.domain.Movie
import com.kwang0.movierepository.domain.Observer
import com.kwang0.movierepository.domain.interactor.GetMovies
import com.kwang0.movierepository.domain.interactor.UseCaseFactory
import com.kwang0.movierepository.utils.Formatter
import io.reactivex.disposables.CompositeDisposable


class MainPresenter(
    private val view: MainContract.View,
    private val useCaseFactory: UseCaseFactory,
    private val formatter: Formatter,
): MainContract.Presenter {

    override val disposables: CompositeDisposable = CompositeDisposable()

    private var movieList = emptyList<Movie>()

    private var selectedMovieId: Int = 0

    override fun viewReady() {
        invokeGetMovies(false)
    }

    override fun refresh() {
        invokeGetMovies(true)
    }

    private fun invokeGetMovies(refresh: Boolean) {
        val useCase = useCaseFactory.getMovies()
        addDisposable(useCase.execute(MoviesObserver(), GetMovies.Params(refresh)))
    }

    private inner class MoviesObserver : Observer<List<Movie>>() {
        override fun onSuccess(t: List<Movie>) {
            saveMovies(t)
            view.let {
                it.cancelRefreshDialog()
                it.refreshList()
            }
        }

        override fun onError(e: Throwable) {
            view.let {
                it.cancelRefreshDialog()
                it.showErrorMessage(e.message!!)
            }
        }
    }

    override fun getItemsCount(): Int {
        return if(moviesListIsEmpty()) 0 else movieList.size
    }

    override fun configureCell(movieCellView: MoviesAdapter.MovieCellView, position: Int) {
        val movie = getMovie(position)
        movieCellView.displayImage(formatter.getCompleteUrlImage(movie.posterPath))
    }

    override fun onItemClick(position: Int) {
        val movie = getMovie(position)
        saveSelectedMovieId(movie.id)
        view.navigateToDetailScreen(getSelectedMovieId())
    }

    private fun saveMovies(movieList: List<Movie>) {
        this.movieList = movieList
    }

    private fun getMovie(position: Int): Movie {
        return movieList[position]
    }

    private fun saveSelectedMovieId(selectedMovieId: Int) {
        this.selectedMovieId = selectedMovieId
    }

    private fun moviesListIsEmpty(): Boolean {
        return movieList.isEmpty()
    }

    private fun getSelectedMovieId(): Int {
        return selectedMovieId
    }

}

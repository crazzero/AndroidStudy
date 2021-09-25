package com.kwang0.movierepository.ui.feature.main

import com.kwang0.movierepository.base.BasePresenter
import com.kwang0.movierepository.base.BaseView

interface MainContract {
    interface View: BaseView {
        fun refreshList()

        fun cancelRefreshDialog()

        fun navigateToDetailScreen(movieId: Int)
    }

    interface Presenter: BasePresenter {

        fun viewReady()

        fun refresh()

        fun getItemsCount(): Int
        fun configureCell(movieCellView: MoviesAdapter.MovieCellView, position: Int)
        fun onItemClick(position: Int)
    }
}
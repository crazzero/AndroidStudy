package com.kwang0.movierepository.ui.feature.detail

import com.kwang0.movierepository.base.BasePresenter
import com.kwang0.movierepository.base.BaseView

interface DetailContract {
    interface View: BaseView {
        fun displayImage(url: String)

        fun displayTitle(title: String)

        fun displayVoteAverage(voteAverage: String)

        fun displayReleaseDate(releaseDate: String)

        fun displayOverview(overview: String)

        fun goToBack()
    }

    interface Presenter: BasePresenter {
        fun viewReady()

        fun navUpSelected()
    }
}
package com.kwang0.movierepository.presentation.di.detail

import com.kwang0.movierepository.domain.interactor.UseCaseFactory
import com.kwang0.movierepository.ui.feature.detail.DetailContract
import com.kwang0.movierepository.ui.feature.detail.DetailPresenter
import com.kwang0.movierepository.ui.feature.detail.DetailActivity
import com.kwang0.movierepository.utils.Formatter
import dagger.Module
import dagger.Provides


@Module
class DetailActivityModule {

    @Provides
    internal fun providePresenter(
        activity: DetailActivity,
        useCaseFactory: UseCaseFactory,
        formatter: Formatter
    ): DetailContract.Presenter {
        val movieId = activity.intent.getIntExtra(DetailActivity.EXTRA_MOVIE_ID, -1)
        return DetailPresenter(activity, useCaseFactory, formatter, movieId)
    }

}

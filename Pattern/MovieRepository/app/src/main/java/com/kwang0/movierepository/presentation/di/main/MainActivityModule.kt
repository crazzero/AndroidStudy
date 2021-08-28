package com.kwang0.movierepository.presentation.di.main

import com.kwang0.movierepository.domain.interactor.UseCaseFactory
import com.kwang0.movierepository.presentation.contract.MainContract
import com.kwang0.movierepository.presentation.presenter.MainPresenter
import com.kwang0.movierepository.presentation.view.MainActivity
import com.kwang0.movierepository.utils.Formatter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    internal fun providePresenter(
        activity: MainActivity,
        useCaseFactory: UseCaseFactory,
        formatter: Formatter
    ): MainContract.Presenter {
        return MainPresenter(activity, useCaseFactory, formatter)
    }

}

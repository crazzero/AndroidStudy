package com.kwang0.tdd.presentation

import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val view: MainContract.View
) : MainContract.Presenter {
    override fun fetch() {
    }
}

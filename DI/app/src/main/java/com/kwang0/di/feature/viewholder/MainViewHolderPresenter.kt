package com.kwang0.di.feature.viewholder

import javax.inject.Inject

class MainViewHolderPresenter @Inject constructor(
//    private val view: MainViewHolderContract.ViewHolder
) : MainViewHolderContract.Presenter {
    private var view: MainViewHolderContract.ViewHolder? = null

    override fun setView(view: MainViewHolderContract.ViewHolder) {
        this.view = view
    }

    override fun call() {
        view?.onCall()
    }
}

package com.kwang0.di.feature

import com.kwang0.di.feature.contract.MainViewHolderContract
import javax.inject.Inject

class MainViewHolderPresenter @Inject constructor(
    private val view: MainViewHolderContract.ViewHolder
) : MainViewHolderContract.Presenter {
    override fun call() {
        view.onCall()
    }
}

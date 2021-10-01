package com.kwang0.di.feature.viewholder

import com.kwang0.di.feature.viewholder.MainViewHolderContract
import javax.inject.Inject

class MainViewHolderPresenter @Inject constructor(
    private val view: MainViewHolderContract.ViewHolder
) : MainViewHolderContract.Presenter {
    override fun call() {
        view.onCall()
    }
}

package com.kwang0.di.feature

class SecondPresenter internal constructor(
    private val view: SecondContract.View,
) : SecondContract.Presenter {
    override fun onClicked() {
        view.setSecondText("clicked!!!")
    }
}

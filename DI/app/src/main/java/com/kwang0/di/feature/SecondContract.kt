package com.kwang0.di.feature

interface SecondContract {
    interface View {
        fun setSecondText(value: String)
    }

    interface Presenter {
        fun onClicked()
    }
}

package com.kwang0.tdd.presentation

interface MainContract {
    interface View {
        fun onFetchResult()
    }

    interface Presenter {
        fun fetch()
    }
}

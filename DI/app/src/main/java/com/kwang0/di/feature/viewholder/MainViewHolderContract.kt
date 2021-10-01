package com.kwang0.di.feature.viewholder

interface MainViewHolderContract {

    interface ViewHolder {
        fun onCall()
    }

    interface Presenter {
        fun setView(view: ViewHolder)
        fun call()
    }
}

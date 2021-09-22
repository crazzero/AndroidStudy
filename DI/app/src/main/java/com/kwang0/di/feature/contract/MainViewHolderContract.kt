package com.kwang0.di.feature.contract

import com.kwang0.di.feature.di.ViewHolderComponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn

interface MainViewHolderContract {

    interface ViewHolder {
        fun onCall()
    }

    interface Presenter {
        fun call()
    }
}

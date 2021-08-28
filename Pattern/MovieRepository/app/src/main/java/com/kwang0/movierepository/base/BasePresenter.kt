package com.kwang0.movierepository.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

interface BasePresenter {
    val disposables: CompositeDisposable

    fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    fun destroy() {
        disposables.dispose()
    }
}

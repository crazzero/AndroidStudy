package com.kwang0.movierepository.ui.base

import com.kwang0.movierepository.domain.executor.UIScheduler
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class UIThread: UIScheduler {
    override fun getScheduler(): Scheduler = AndroidSchedulers.mainThread()
}

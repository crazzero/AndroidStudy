package com.kwang0.movierepository.domain.executor

import io.reactivex.Scheduler

interface UIScheduler {
    fun getScheduler(): Scheduler
}

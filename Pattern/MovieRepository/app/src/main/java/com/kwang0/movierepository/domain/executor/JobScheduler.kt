package com.kwang0.movierepository.domain.executor

import io.reactivex.Scheduler

interface JobScheduler {
    fun getScheduler(): Scheduler
}

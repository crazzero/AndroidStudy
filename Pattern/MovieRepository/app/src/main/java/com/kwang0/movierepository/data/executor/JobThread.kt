package com.kwang0.movierepository.data.executor

import com.kwang0.movierepository.domain.executor.JobScheduler
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class JobThread: JobScheduler {
    override fun getScheduler(): Scheduler = Schedulers.io()
}

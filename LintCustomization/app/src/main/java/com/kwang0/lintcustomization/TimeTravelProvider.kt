package com.kwang0.lintcustomization

@Suppress("unused")
@TimeTravelExperiment
class TimeTravelProvider {
    var timeInternal: Long = 0

    fun setTime(timestamp: Long) {
        timeInternal = timestamp
    }
}

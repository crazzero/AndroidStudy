package com.kwang0.di.test

import javax.inject.Inject

interface Test {
    fun test()
}

class TestImpl @Inject constructor() : Test {
    override fun test() {
        print("This is test implements fun")
    }
}

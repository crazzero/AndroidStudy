package com.kwang0.di.test

import javax.inject.Inject

class TestClass @Inject constructor(private val test: Test) {
    fun test() {
        test.test()
    }
}

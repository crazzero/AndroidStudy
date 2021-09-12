package com.kwang0.fragment.ui.second

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {

    private val _updateFragmentCount = MutableLiveData<Int>(0)
    val updateFragmentCount: LiveData<Int> get() = _updateFragmentCount

    fun insertCountTwo() {
        _updateFragmentCount.value = (updateFragmentCount.value ?: 0) + 2
    }
}

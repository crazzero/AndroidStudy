package com.kwang0.fragment.ui.third

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ThirdViewModel : ViewModel() {

    private val _updateFragmentCount = MutableLiveData<Int>(0)
    val updateFragmentCount: LiveData<Int> get() = _updateFragmentCount

    fun insertCountThree() {
        _updateFragmentCount.value = (updateFragmentCount.value ?: 0) + 3
    }
}

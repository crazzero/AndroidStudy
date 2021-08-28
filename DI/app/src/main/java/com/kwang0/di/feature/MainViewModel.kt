package com.kwang0.di.feature

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.kwang0.di.test.SomeClass
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val someClass: SomeClass
    , @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    //...
}

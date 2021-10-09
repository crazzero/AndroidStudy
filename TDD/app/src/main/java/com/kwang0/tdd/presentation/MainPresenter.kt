package com.kwang0.tdd.presentation

import com.kwang0.tdd.domain.SetThemeModeUseCase
import com.kwang0.tdd.enum.ThemeMode
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val view: MainContract.View,
    private val setThemeModeUseCase: SetThemeModeUseCase,
) : MainContract.Presenter {
    override fun fetchTheme(themeMode: ThemeMode) {
        setThemeModeUseCase.execute(themeMode)
    }
}

package com.kwang0.tdd.presentation

import com.kwang0.tdd.domain.GetCountUseCase
import com.kwang0.tdd.domain.SaveCountUseCase
import com.kwang0.tdd.domain.SetThemeModeUseCase
import com.kwang0.tdd.enum.ThemeMode
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val view: MainContract.View,
    private val setThemeModeUseCase: SetThemeModeUseCase,
    private val getCountUseCase: GetCountUseCase,
    private val saveCountUseCase: SaveCountUseCase,
) : MainContract.Presenter {
    override fun fetchTheme(themeMode: ThemeMode) {
        setThemeModeUseCase.execute(themeMode)
    }

    override fun getCount(): Int {
        return getCountUseCase.execute()
    }

    override fun saveCount(count: Int) {
        saveCountUseCase.execute(count)
    }
}

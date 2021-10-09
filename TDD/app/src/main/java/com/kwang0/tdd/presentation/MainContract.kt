package com.kwang0.tdd.presentation

import com.kwang0.tdd.enum.ThemeMode

interface MainContract {
    interface View {
    }

    interface Presenter {
        fun fetchTheme(themeMode: ThemeMode)
    }
}

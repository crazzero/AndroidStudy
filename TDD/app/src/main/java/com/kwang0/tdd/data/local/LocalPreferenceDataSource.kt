package com.kwang0.tdd.data.local

import android.content.SharedPreferences
import com.kwang0.tdd.enum.ThemeMode
import javax.inject.Inject

interface LocalPreferenceDataSource {
    var themeMode: ThemeMode
}

class LocalPreferenceDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences,
) : LocalPreferenceDataSource {

    override var themeMode: ThemeMode
        get() = ThemeMode.fromValue(sharedPreferences.getString(PREFS_THEME_MODE, null))
        set(value) = sharedPreferences.edit()?.putString(PREFS_THEME_MODE, value.value)?.apply() ?: Unit

    companion object {
        const val PREFS_THEME_MODE = "PREFS_THEME_MODE"
    }
}

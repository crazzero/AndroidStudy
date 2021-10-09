package com.kwang0.tdd.enum

enum class ThemeMode(val value: String) {
    SYSTEM(ThemeMode.THEME_MODE_SYSTEM),
    LIGHT(ThemeMode.THEME_MODE_LIGHT),
    DARK(ThemeMode.THEME_MODE_DARK);

    companion object {
        const val THEME_MODE_SYSTEM = "system"
        const val THEME_MODE_LIGHT = "light"
        const val THEME_MODE_DARK = "dark"

        fun fromValue(value: String?): ThemeMode {
            return values().firstOrNull { it.value == value } ?: SYSTEM
        }
    }
}

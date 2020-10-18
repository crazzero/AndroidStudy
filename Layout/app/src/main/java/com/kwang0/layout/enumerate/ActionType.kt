package com.kwang0.layout.enumerate

import com.kwang0.layout.R

enum class ActionType {
    BACK, EXIT, SETTING, NONE;

    val icon: Int
        get() {
            return when (this) {
                BACK -> R.drawable.ic_back
                EXIT -> R.drawable.ic_exit
                SETTING -> R.drawable.ic_setting
                else -> 0
            }
        }
}
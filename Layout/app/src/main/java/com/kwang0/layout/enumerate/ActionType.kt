package com.kwang0.layout.enumerate

import com.kwang0.layout.R

enum class ActionType {
    SETTING;

    companion object {
        fun getDrawable(type: ActionType) {
            when (type) {
                SETTING -> R.drawable.ic_setting
            }
        }
    }
}
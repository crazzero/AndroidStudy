package com.kwang0.layout.common

import com.kwang0.layout.enumerate.ActionType

interface Screen {
    val backgroundColor: Int
    val textColor: Int
    fun menuButtonClicked(actionType: ActionType)
}
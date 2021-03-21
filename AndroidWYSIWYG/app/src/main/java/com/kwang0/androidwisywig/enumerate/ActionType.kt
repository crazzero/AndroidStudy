package com.kwang0.androidwisywig.enumerate

import androidx.annotation.DrawableRes
import com.kwang0.androidwisywig.R

enum class ActionType(@DrawableRes resId: Int) {

    BOLD(R.drawable.bold),
    ITALIC(R.drawable.italic),
}

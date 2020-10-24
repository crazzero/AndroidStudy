package com.kwang0.resource

import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

class ResUtils {

    companion object {
        @JvmStatic
        fun getColor(@ColorRes colorId: Int): Int {
            return ContextCompat.getColor(App.appContext, colorId)
        }
    }
}
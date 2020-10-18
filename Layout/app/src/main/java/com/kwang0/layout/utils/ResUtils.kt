package com.kwang0.layout.utils

import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.kwang0.layout.common.App

class ResUtils {

    companion object {
        @JvmStatic
        fun getColor(@ColorRes colorId: Int): Int {
            return ContextCompat.getColor(App.appContext, colorId)
        }
    }
}
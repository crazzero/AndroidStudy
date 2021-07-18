package com.kwang0.toast.utils

import android.content.Context

object ResourceUtils {
    fun getString(context: Context, resId: Int): String {
        return context.getString(resId)
    }
}

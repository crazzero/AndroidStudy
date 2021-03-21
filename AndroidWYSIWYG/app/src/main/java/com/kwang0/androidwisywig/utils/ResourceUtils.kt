package com.kwang0.androidwisywig.utils

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Build
import com.kwang0.androidwisywig.App

object ResourceUtils {

    @SuppressLint("UseCompatLoadingForDrawables")
    fun getDrawable(icon: Int): Drawable? {
        try {
            App.appContext?.also {
                return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    it.resources.getDrawable(icon, null)
                } else {
                    it.resources.getDrawable(icon)
                }
            }
        } catch (e: Exception) { }

        return null
    }
}
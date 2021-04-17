package com.kwang0.resource

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.animation.Animation
import android.view.animation.AnimationUtils

object ResUtils {

    fun getString(key: String?): String {
        if (key == null) {
            return ""
        }

        try {
            App.appContext?.also {
                val resId: Int = it.resources.getIdentifier(key, "string", it.packageName)
                if (resId != 0) {
                    return it.resources.getString(resId)
                }
            }
        } catch (e: Exception) { }

        return key
    }

    fun getColor(key: String?): Int? {
        if (key == null) {
            return null
        }

        try {
            App.appContext?.also {
                val resId: Int = it.resources.getIdentifier(key, "color", it.packageName)
                if (resId != 0) {
                    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        it.resources.getColor(resId, null)
                    } else {
                        it.resources.getColor(resId)
                    }
                }
            }
        } catch (e: Exception) { }

        return null
    }

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

    fun getAnimation(key: String?): Animation? {
        if (key == null) {
            return null
        }

        try {
            App.appContext?.also {
                val resId: Int = it.resources.getIdentifier(key, "anim", it.packageName)
                if (resId != 0) {
                    return AnimationUtils.loadAnimation(it, resId)
                }
            }
        } catch (e: Exception) { }

        return null
    }

    fun getDimen(id: Int): Float {
        try {
            App.appContext.also {
                return it.resources.getDimension(id)
            }
        } catch (e: Exception) { }

        return 0f
    }

    fun getPixel(id: Int): Int {
        try {
            App.appContext.also {
                return it.resources.getDimensionPixelSize(id)
            }
        } catch (e: Exception) { }

        return 0
    }
}

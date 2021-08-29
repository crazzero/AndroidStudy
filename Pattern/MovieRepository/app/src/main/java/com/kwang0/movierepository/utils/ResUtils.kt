package com.kwang0.movierepository.utils

import com.kwang0.movierepository.MoviesApp

object ResUtils {
    fun getString(key: String?): String {
        if (key == null) {
            return ""
        }

        try {
            MoviesApp.appContext.also {
                val resId: Int = it.resources.getIdentifier(key, "string", it.packageName)
                if (resId != 0) {
                    return it.resources.getString(resId)
                }
            }
        } catch (e: Exception) { }

        return key
    }
}

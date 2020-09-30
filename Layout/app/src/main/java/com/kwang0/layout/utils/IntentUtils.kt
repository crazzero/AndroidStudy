package com.kwang0.layout.utils

import android.content.Context
import android.content.Intent

class IntentUtils(private val context: Context) {
    fun startActivity(clazz: Class<*>) {
        context.startActivity(Intent(context, clazz))
    }
}

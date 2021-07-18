package com.kwang0.toast.helper

import android.content.Context
import android.view.Gravity
import android.widget.Toast

object SystemToastHelper {
    fun showShortToast(context: Context, message: String?) {
        showShortToast(context, message, 0, 0, 0)
    }

    fun showShortToast(
        context: Context,
        message: String?,
        gravity: Int = Gravity.BOTTOM,
        xOffset: Int = 0,
        yOffset: Int = 0
    ) {
        message?.also {
            when {
                gravity == 0 && xOffset == 0 && yOffset == 0 -> {
                    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(context, it, Toast.LENGTH_SHORT).also { toast ->
                        toast.setGravity(gravity, xOffset, yOffset)
                        toast.show()
                    }
                }
            }
        }
    }

    fun showLongToast(context: Context, message: String?) {
        showLongToast(context, message, 0, 0, 0)
    }

    fun showLongToast(context: Context, message: String?, gravity: Int, xOffset: Int, yOffset: Int) {
        message?.also {
            when {
                gravity == 0 && xOffset == 0 && yOffset == 0 -> {
                    Toast.makeText(context, it, Toast.LENGTH_LONG).show()
                }
                else -> {
                    Toast.makeText(context, it, Toast.LENGTH_LONG).also { toast ->
                        toast.setGravity(gravity, xOffset, yOffset)
                        toast.show()
                    }
                }
            }
        }
    }
}

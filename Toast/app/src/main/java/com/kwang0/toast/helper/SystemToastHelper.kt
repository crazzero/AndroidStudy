package com.kwang0.toast.helper

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.kwang0.toast.R
import com.kwang0.toast.utils.ResourceUtils

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

    fun showToast(view: View, message: String?) {
        when (view.tag) {
            ResourceUtils.getString(view.context, R.string.tag_short_toast) -> {
                showShortToast(view.context, message)
            }

            ResourceUtils.getString(view.context, R.string.tag_short_gravity_toast) -> {
                showShortToast(view.context, message, Gravity.TOP, 0, 0)
            }

            ResourceUtils.getString(view.context, R.string.tag_long_toast) -> {
                showLongToast(view.context, message)
            }

            ResourceUtils.getString(view.context, R.string.tag_long_gravity_toast) -> {
                showLongToast(view.context, message, Gravity.TOP, 0, 0)
            }
        }
    }
}

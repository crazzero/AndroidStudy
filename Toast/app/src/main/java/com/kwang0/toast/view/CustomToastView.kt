package com.kwang0.toast.view

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatTextView

class CustomToastView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private var count = 0

    fun showCustomToast() {
        clearAnimation()
        text = "$count"

        visibility = View.VISIBLE
        animate().apply {
            duration = 500
            alpha(0.8f)
            setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    hideCustomToast()
                }
            })
        }.start()
        addCount()
    }

    private fun hideCustomToast() {
        animate().apply {
            duration = 500
            startDelay = 500
            alpha(0.0f)
            setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    visibility = View.GONE
                }
            })
        }.start()
    }

    private fun addCount() {
        count++
    }
}

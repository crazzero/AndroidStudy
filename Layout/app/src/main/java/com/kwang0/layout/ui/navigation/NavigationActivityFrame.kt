package com.kwang0.layout.ui.navigation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.kwang0.layout.R
import kotlinx.android.synthetic.main.view_navigation_activity_frame.view.*

class NavigationActivityFrame @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_navigation_activity_frame, this)
    }

    fun setRootLayout(view: View) {
        layoutActivityFrame.addView(view)
    }
}

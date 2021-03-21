package com.kwang0.androidwisywig.ui.layout

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.kwang0.androidwisywig.R
import com.kwang0.androidwisywig.enumerate.ActionType

class ActionLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_action, this)
    }

    fun setActions(actionTypes: List<ActionType>) {
        
    }
}

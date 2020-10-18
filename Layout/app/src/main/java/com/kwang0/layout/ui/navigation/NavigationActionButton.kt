package com.kwang0.layout.ui.navigation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.kwang0.layout.R
import com.kwang0.layout.enumerate.ActionType
import com.kwang0.layout.utils.ResUtils
import kotlinx.android.synthetic.main.view_navigation_action_button.view.*

class NavigationActionButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var icon: Int = 0
        set(value) {
            field = value
            imageNavigationAction.setImageResource(value)
        }

    var action: ActionType = ActionType.NONE

    init {
        LayoutInflater.from(context).inflate(R.layout.view_navigation_action_button, this)
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)

        val color: Int = if (enabled) {
            R.color.grey900
        } else {
            R.color.grey600
        }

        imageNavigationAction.setColorFilter(ResUtils.getColor(color))
    }

    override fun setOnClickListener(l: OnClickListener?) {
        imageNavigationAction.setOnClickListener {
            if (isEnabled) {
                l?.onClick(it)
            }
        }
    }
}
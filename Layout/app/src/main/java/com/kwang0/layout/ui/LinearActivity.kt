package com.kwang0.layout.ui

import android.widget.LinearLayout
import com.kwang0.layout.R
import com.kwang0.layout.enumerate.ActionState
import com.kwang0.layout.enumerate.ActionType
import com.kwang0.layout.ui.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_linear.*

class LinearActivity : NavigationActivity() {

    override val layoutId: Int
        get() = R.layout.activity_linear

    override fun initActivity() {
        initNavigation(this)
            .activateBack()
            .addAction(ActionType.CHANGE, ActionState.VISIBLE)
    }

    override fun menuButtonClicked(actionType: ActionType) {
        super.menuButtonClicked(actionType)

        when (actionType) {
            ActionType.CHANGE -> {
                layoutLinearRoot.orientation = when (layoutLinearRoot.orientation) {
                    LinearLayout.HORIZONTAL -> LinearLayout.VERTICAL
                    LinearLayout.VERTICAL -> LinearLayout.HORIZONTAL
                    else -> LinearLayout.HORIZONTAL
                }
            }
        }
    }
}

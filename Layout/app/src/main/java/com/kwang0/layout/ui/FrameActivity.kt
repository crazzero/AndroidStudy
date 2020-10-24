package com.kwang0.layout.ui

import com.kwang0.layout.ui.navigation.NavigationActivity
import com.kwang0.layout.R
import com.kwang0.layout.enumerate.ActionState
import com.kwang0.layout.enumerate.ActionType
import kotlinx.android.synthetic.main.activity_frame.*

class FrameActivity : NavigationActivity() {

    override val layoutId: Int
        get() = R.layout.activity_frame

    override fun initActivity() {
        initNavigation(this)
            .activateBack()
            .addAction(ActionType.CHANGE, ActionState.VISIBLE)
    }

    override fun menuButtonClicked(actionType: ActionType) {
        super.menuButtonClicked(actionType)

        when (actionType) {
            ActionType.CHANGE -> {

            }
        }
    }
}

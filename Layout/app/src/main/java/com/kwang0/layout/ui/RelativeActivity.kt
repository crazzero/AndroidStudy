package com.kwang0.layout.ui

import com.kwang0.layout.ui.navigation.NavigationActivity
import com.kwang0.layout.R
import com.kwang0.layout.enumerate.ActionState
import com.kwang0.layout.enumerate.ActionType

class RelativeActivity : NavigationActivity() {

    override val layoutId: Int
        get() = R.layout.activity_relative

    override fun initActivity() {
        initNavigation(this)
            .activateBack()
            .addAction(ActionType.SETTING, ActionState.VISIBLE)
    }

    override fun menuButtonClicked(actionType: ActionType) {
        super.menuButtonClicked(actionType)

        when (actionType) {
            ActionType.SETTING -> {

            }
        }
    }
}

package com.kwang0.layout.ui

import com.kwang0.layout.ui.navigation.NavigationActivity
import com.kwang0.layout.R
import com.kwang0.layout.enumerate.ActionState
import com.kwang0.layout.enumerate.ActionType

class ConstraintActivity : NavigationActivity() {

    override val layoutId: Int
        get() = R.layout.activity_constraint

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

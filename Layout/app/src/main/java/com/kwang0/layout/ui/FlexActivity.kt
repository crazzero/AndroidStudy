package com.kwang0.layout.ui

import com.google.android.flexbox.FlexDirection
import com.kwang0.layout.R
import com.kwang0.layout.enumerate.ActionState
import com.kwang0.layout.enumerate.ActionType
import com.kwang0.layout.enumerate.OrientationState
import com.kwang0.layout.ui.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_flex.*

class FlexActivity : NavigationActivity() {

    override val layoutId: Int
        get() = R.layout.activity_flex

    private var frameOrientation: OrientationState = OrientationState.VERTICAL

    override fun initActivity() {
        initNavigation(this)
            .activateBack()
            .addAction(ActionType.CHANGE, ActionState.VISIBLE)
    }

    override fun menuButtonClicked(actionType: ActionType) {
        super.menuButtonClicked(actionType)

        when (actionType) {
            ActionType.CHANGE -> {
                toggleOrientation()
            }
        }
    }

    private fun toggleOrientation() {
        when (frameOrientation) {
            OrientationState.VERTICAL -> setHorizontal()
            OrientationState.HORIZONTAL -> setVertical()
        }
    }

    private fun setVertical() {
        layoutFlexRoot.flexDirection = FlexDirection.ROW

        frameOrientation = OrientationState.VERTICAL
    }

    private fun setHorizontal() {
        layoutFlexRoot.flexDirection = FlexDirection.COLUMN

        frameOrientation = OrientationState.HORIZONTAL
    }
}
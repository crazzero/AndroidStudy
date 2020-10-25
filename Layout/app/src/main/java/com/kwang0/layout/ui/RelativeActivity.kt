package com.kwang0.layout.ui

import android.view.View
import android.widget.RelativeLayout
import com.kwang0.layout.R
import com.kwang0.layout.enumerate.ActionState
import com.kwang0.layout.enumerate.ActionType
import com.kwang0.layout.enumerate.OrientationState
import com.kwang0.layout.ui.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_relative.*

class RelativeActivity : NavigationActivity() {

    override val layoutId: Int
        get() = R.layout.activity_relative

    private var relativeOrientation: OrientationState = OrientationState.VERTICAL

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
        when (relativeOrientation) {
            OrientationState.VERTICAL -> setHorizontal()
            OrientationState.HORIZONTAL -> setVertical()
        }
    }

    private fun setVertical() {
        if (
            viewRelative2.layoutParams is RelativeLayout.LayoutParams
            && viewRelative3.layoutParams is RelativeLayout.LayoutParams
            && viewRelative4.layoutParams is RelativeLayout.LayoutParams
        ) {
            val lp2 = viewRelative2.layoutParams as RelativeLayout.LayoutParams
            val lp3 = viewRelative3.layoutParams as RelativeLayout.LayoutParams
            val lp4 = viewRelative4.layoutParams as RelativeLayout.LayoutParams

            setVerticalRelative(R.id.viewRelative1, viewRelative2, lp2)
            setVerticalRelative(R.id.viewRelative2, viewRelative3, lp3)
            setVerticalRelative(R.id.viewRelative3, viewRelative4, lp4)
        }

        relativeOrientation = OrientationState.VERTICAL
    }

    private fun setHorizontal() {
        if (
            viewRelative2.layoutParams is RelativeLayout.LayoutParams
            && viewRelative3.layoutParams is RelativeLayout.LayoutParams
            && viewRelative4.layoutParams is RelativeLayout.LayoutParams
        ) {
            val lp2 = viewRelative2.layoutParams as RelativeLayout.LayoutParams
            val lp3 = viewRelative3.layoutParams as RelativeLayout.LayoutParams
            val lp4 = viewRelative4.layoutParams as RelativeLayout.LayoutParams

            setHorizontalRelative(R.id.viewRelative1, viewRelative2, lp2)
            setHorizontalRelative(R.id.viewRelative2, viewRelative3, lp3)
            setHorizontalRelative(R.id.viewRelative3, viewRelative4, lp4)
        }

        relativeOrientation = OrientationState.HORIZONTAL
    }
    
    private fun setVerticalRelative(targetId: Int, view2: View, lp: RelativeLayout.LayoutParams) {
        lp.removeRule(RelativeLayout.END_OF)
        lp.addRule(RelativeLayout.BELOW, targetId)
        view2.layoutParams = lp
    }

    private fun setHorizontalRelative(targetId: Int, view2: View, lp: RelativeLayout.LayoutParams) {
        lp.removeRule(RelativeLayout.BELOW)
        lp.addRule(RelativeLayout.END_OF, targetId)
        view2.layoutParams = lp
    }
}

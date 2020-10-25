package com.kwang0.layout.ui

import android.view.View
import android.widget.FrameLayout
import com.kwang0.layout.R
import com.kwang0.layout.enumerate.ActionState
import com.kwang0.layout.enumerate.ActionType
import com.kwang0.layout.enumerate.OrientationState
import com.kwang0.layout.ui.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_frame.*

class FrameActivity : NavigationActivity() {

    override val layoutId: Int
        get() = R.layout.activity_frame

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
        if (
            viewFrame1.layoutParams is FrameLayout.LayoutParams
            && viewFrame2.layoutParams is FrameLayout.LayoutParams
            && viewFrame3.layoutParams is FrameLayout.LayoutParams
            && viewFrame4.layoutParams is FrameLayout.LayoutParams
        ) {
            val lp1 = viewFrame1.layoutParams as FrameLayout.LayoutParams
            val lp2 = viewFrame2.layoutParams as FrameLayout.LayoutParams
            val lp3 = viewFrame3.layoutParams as FrameLayout.LayoutParams
            val lp4 = viewFrame4.layoutParams as FrameLayout.LayoutParams

            setVerticalMargins(viewFrame1, lp1, 0)
            setVerticalMargins(viewFrame2, lp2, lp1.height)
            setVerticalMargins(viewFrame3, lp3, lp1.height + lp2.height)
            setVerticalMargins(viewFrame4, lp4, lp1.height + lp2.height + lp3.height)
        }

        frameOrientation = OrientationState.VERTICAL
    }

    private fun setHorizontal() {
        if (
            viewFrame1.layoutParams is FrameLayout.LayoutParams
            && viewFrame2.layoutParams is FrameLayout.LayoutParams
            && viewFrame3.layoutParams is FrameLayout.LayoutParams
            && viewFrame4.layoutParams is FrameLayout.LayoutParams
        ) {
            val lp1 = viewFrame1.layoutParams as FrameLayout.LayoutParams
            val lp2 = viewFrame2.layoutParams as FrameLayout.LayoutParams
            val lp3 = viewFrame3.layoutParams as FrameLayout.LayoutParams
            val lp4 = viewFrame4.layoutParams as FrameLayout.LayoutParams

            setHorizontalMargins(viewFrame1, lp1, lp1.width + (lp2.width / 2))
            setHorizontalMargins(viewFrame2, lp2, lp2.width / 2)
            setHorizontalMargins(viewFrame3, lp3, - (lp3.width / 2))
            setHorizontalMargins(viewFrame4, lp4, - ((lp3.width / 2) + lp4.width))
        }

        frameOrientation = OrientationState.HORIZONTAL
    }

    private fun setVerticalMargins(view: View, lp: FrameLayout.LayoutParams, margin: Int) {
        lp.setMargins(0, margin, 0, 0)
        view.layoutParams = lp
    }

    private fun setHorizontalMargins(view: View, lp: FrameLayout.LayoutParams, margin: Int) {
        lp.setMargins(0, 0, margin, 0)
        view.layoutParams = lp
    }
}

package com.kwang0.layout.ui

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.kwang0.layout.R
import com.kwang0.layout.enumerate.ActionState
import com.kwang0.layout.enumerate.ActionType
import com.kwang0.layout.enumerate.OrientationState
import com.kwang0.layout.ui.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_constraint.*
import kotlinx.android.synthetic.main.activity_frame.*

class ConstraintActivity : NavigationActivity() {

    override val layoutId: Int
        get() = R.layout.activity_constraint

    private var constraintOrientation: OrientationState = OrientationState.VERTICAL

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
        when (constraintOrientation) {
            OrientationState.VERTICAL -> setHorizontal()
            OrientationState.HORIZONTAL -> setVertical()
        }
    }

    private fun setVertical() {
        if (
            viewConstraint1.layoutParams is ConstraintLayout.LayoutParams
            && viewConstraint2.layoutParams is ConstraintLayout.LayoutParams
            && viewConstraint3.layoutParams is ConstraintLayout.LayoutParams
            && viewConstraint4.layoutParams is ConstraintLayout.LayoutParams
        ) {
            val lp1 = viewConstraint1.layoutParams as ConstraintLayout.LayoutParams
            val lp2 = viewConstraint2.layoutParams as ConstraintLayout.LayoutParams
            val lp3 = viewConstraint3.layoutParams as ConstraintLayout.LayoutParams
            val lp4 = viewConstraint4.layoutParams as ConstraintLayout.LayoutParams

            setVerticalConstraint(viewConstraint1, layoutConstraintRoot, viewConstraint2, lp1)
            setVerticalConstraint(viewConstraint2, viewConstraint1, viewConstraint3, lp2)
            setVerticalConstraint(viewConstraint3, viewConstraint2, viewConstraint4, lp3)
            setVerticalConstraint(viewConstraint4, viewConstraint3, null, lp4)
        }

        constraintOrientation = OrientationState.VERTICAL
    }

    private fun setHorizontal() {
        if (
            viewConstraint1.layoutParams is ConstraintLayout.LayoutParams
            && viewConstraint2.layoutParams is ConstraintLayout.LayoutParams
            && viewConstraint3.layoutParams is ConstraintLayout.LayoutParams
            && viewConstraint4.layoutParams is ConstraintLayout.LayoutParams
        ) {
            val lp1 = viewConstraint1.layoutParams as ConstraintLayout.LayoutParams
            val lp2 = viewConstraint2.layoutParams as ConstraintLayout.LayoutParams
            val lp3 = viewConstraint3.layoutParams as ConstraintLayout.LayoutParams
            val lp4 = viewConstraint4.layoutParams as ConstraintLayout.LayoutParams

            setHorizontalConstraint(viewConstraint1, layoutConstraintRoot, viewConstraint2, lp1)
            setHorizontalConstraint(viewConstraint2, viewConstraint1, viewConstraint3, lp2)
            setHorizontalConstraint(viewConstraint3, viewConstraint2, viewConstraint4, lp3)
            setHorizontalConstraint(viewConstraint4, viewConstraint3, layoutConstraintRoot, lp4)
        }

        constraintOrientation = OrientationState.HORIZONTAL
    }

    private fun setVerticalConstraint(
        view: View,
        targetTopView: View,
        targetBottomView: View?,
        lp: ConstraintLayout.LayoutParams
    ) {
        if (targetTopView.id == layoutConstraintRoot.id) {
            lp.topToTop = layoutConstraintRoot.id
            lp.topToBottom = ConstraintLayout.LayoutParams.UNSET
        } else {
            lp.topToTop = ConstraintLayout.LayoutParams.UNSET
            lp.topToBottom = targetTopView.id
        }

        lp.startToStart = layoutConstraintRoot.id
        lp.startToEnd = ConstraintLayout.LayoutParams.UNSET

        lp.endToEnd = layoutConstraintRoot.id
        lp.endToStart = ConstraintLayout.LayoutParams.UNSET

        if (targetBottomView != null) {
            lp.bottomToBottom = ConstraintLayout.LayoutParams.UNSET
            lp.bottomToTop = targetBottomView.id
        } else {
            lp.bottomToBottom = ConstraintLayout.LayoutParams.UNSET
            lp.bottomToTop = ConstraintLayout.LayoutParams.UNSET
        }

        view.layoutParams = lp
    }

    private fun setHorizontalConstraint(
        view: View,
        targetStartView: View,
        targetEndView: View,
        lp: ConstraintLayout.LayoutParams
    ) {
        lp.topToTop = layoutConstraintRoot.id
        lp.topToBottom = ConstraintLayout.LayoutParams.UNSET

        if (targetStartView.id == layoutConstraintRoot.id) {
            lp.startToStart = layoutConstraintRoot.id
            lp.startToEnd = ConstraintLayout.LayoutParams.UNSET
        } else {
            lp.startToStart = ConstraintLayout.LayoutParams.UNSET
            lp.startToEnd = targetStartView.id
        }

        if (targetEndView.id == layoutConstraintRoot.id) {
            lp.endToEnd = layoutConstraintRoot.id
            lp.endToStart = ConstraintLayout.LayoutParams.UNSET
        } else {
            lp.endToEnd = ConstraintLayout.LayoutParams.UNSET
            lp.endToStart = targetEndView.id
        }

        lp.bottomToBottom = ConstraintLayout.LayoutParams.UNSET
        lp.bottomToTop = ConstraintLayout.LayoutParams.UNSET

        view.layoutParams = lp
    }
}

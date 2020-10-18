package com.kwang0.layout.ui.navigation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.kwang0.layout.R
import com.kwang0.layout.common.Screen
import com.kwang0.layout.enumerate.ActionState
import com.kwang0.layout.enumerate.ActionType
import kotlinx.android.synthetic.main.view_navigation.view.*

class Navigation @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_navigation, this, true)
    }

    private var actionButtons: MutableList<NavigationActionButton> = arrayListOf()
    private var screen: Screen? = null

    fun withScreen(screen: Screen): Navigation {
        this.screen = screen
        return this
    }

    fun addAction(actionType: ActionType, actionState: ActionState): Navigation {
        return when (actionType) {
            ActionType.BACK -> activateBack()
            ActionType.EXIT -> activateExit()
            else -> activateAction(actionType, actionState)
        }
    }

    fun activateBack(): Navigation {
        layoutNavigationReturnActions.visibility = View.VISIBLE
        buttonNavigationBack.visibility = View.VISIBLE
        buttonNavigationExit.visibility = View.GONE

        layoutNavigationReturnActions.setOnClickListener {
            eventRaised(ActionType.BACK)
        }

        return this
    }

    fun activateExit(): Navigation {
        layoutNavigationReturnActions.visibility = View.VISIBLE
        buttonNavigationBack.visibility = View.GONE
        buttonNavigationExit.visibility = View.VISIBLE

        layoutNavigationReturnActions.setOnClickListener {
            eventRaised(ActionType.EXIT)
        }

        return this
    }

    private fun activateAction(actionType: ActionType, actionState: ActionState, activateColorResId: Int? = R.color.grey900): Navigation {
        NavigationActionButton(context)
            .apply {
                icon = actionType.icon
                action = actionType
                setOnClickListener { eventRaised(actionType) }
            }
            .also {
                actionButtons.add(it)

                setMenuButtonStyle(it, actionState)
                layoutNavigationActions.addView(it)
            }

        return this
    }

    fun setActionState(actionType: ActionType, actionState: ActionState) {
        actionButtons.firstOrNull { actionType == it.action }?.let { setMenuButtonStyle(it, actionState) }
    }

    private fun setMenuButtonStyle(view: View, actionState: ActionState?) {
        when (actionState) {
            ActionState.VISIBLE -> {
                view.visibility = View.VISIBLE
                view.isEnabled = true
            }
            ActionState.DISABLED -> {
                view.visibility = View.VISIBLE
                view.isEnabled = false
            }
            ActionState.HIDDEN -> view.visibility = View.GONE
        }
    }

    private fun eventRaised(actionType: ActionType) {
        screen?.menuButtonClicked(actionType)
    }
}

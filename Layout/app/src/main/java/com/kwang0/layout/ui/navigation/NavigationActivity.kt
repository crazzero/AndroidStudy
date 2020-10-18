package com.kwang0.layout.ui.navigation

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.kwang0.layout.common.Screen
import com.kwang0.layout.enumerate.ActionType
import com.kwang0.layout.utils.ResUtils
import com.kwang0.layout.R
import com.kwang0.layout.utils.Utils
import kotlinx.android.synthetic.main.view_navigation_activity_frame.*
import java.lang.Exception

abstract class NavigationActivity : AppCompatActivity(), Screen {

    override val backgroundColor: Int = Color.WHITE
    override val textColor: Int = ResUtils.getColor(R.color.grey900)

    abstract val layoutId: Int

    abstract fun initActivity()

    fun initNavigation(screen: Screen): Navigation {
        return navigation.withScreen(screen).apply { visibility = View.VISIBLE }
    }

    fun getNavigation(): Navigation {
        return navigation
    }

    override fun setContentView(layoutResId: Int) {
        val rootLayout = layoutInflater.inflate(layoutResId, null)
        val navigationFrame = NavigationActivityFrame(this).apply { setRootLayout(rootLayout) }
        setContentView(navigationFrame)
    }

    override fun menuButtonClicked(actionType: ActionType) {
        when (actionType) {
            ActionType.BACK, ActionType.EXIT -> this.onBackPressed()
        }
    }

    fun init(@LayoutRes layoutResId: Int) {
        setContentView(layoutResId)
        applyTheme()
    }

    open fun applyTheme() {
        setStatusBar(backgroundColor, textColor, true)
    }

    private fun setStatusBar(@ColorInt backColor: Int, @ColorInt textColor: Int, userLightTheme: Boolean) {
        try {
            when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.M -> {
                    window.decorView.apply {
                        systemUiVisibility = if (userLightTheme) {
                            systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                        } else {
                            systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
                        }
                    }
                    window.statusBarColor = backColor
                }
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP -> window.statusBarColor = Utils.addBlackMask(backColor)
            }
        } catch (ex: Exception) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutId)

        // init
        initActivity()
    }
}

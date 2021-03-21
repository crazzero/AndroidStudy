package com.kwang0.androidwisywig.ui.layout

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.kwang0.androidwisywig.R
import com.kwang0.androidwisywig.enumerate.StyleType
import com.kwang0.androidwisywig.utils.ResourceUtils
import kotlinx.android.synthetic.main.layout_action.view.*

class ActionLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var styleType = StyleType.BASE

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_action, this)

        cardActionBold.setOnClickListener {
            if (styleType != StyleType.BOLD) {
                styleType = StyleType.BOLD
                cardActionBold.setCardBackgroundColor(ResourceUtils.getColor(R.color.black10))
            }
        }
    }
}

package com.kwang0.multiitemslayout

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.kwang0.multiitemslayout.databinding.LayoutMultiItemsBinding

class MultiItemsLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var binding: LayoutMultiItemsBinding? = null

    private val componentIds = arrayListOf(
        R.id.rootMultiItems,
        R.id.layoutMainItems,
        R.id.layoutBottomItems
    )

    init {
        binding = LayoutMultiItemsBinding.inflate(LayoutInflater.from(context), this, true)

        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.MultiItemsLayout,
            0,
            0
        )

        try {
            binding?.textTitle?.text = typedArray.getString(R.styleable.MultiItemsLayout_mil_title)
            binding?.textDescription?.text = typedArray.getString(R.styleable.MultiItemsLayout_mil_desc)
        } finally {
            typedArray.recycle()
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()

        binding = null
    }

    override fun addView(child: View?, index: Int, params: ViewGroup.LayoutParams?) {
        if (componentIds.contains(child?.id)) {
            super.addView(child, index, params)
        } else if (child != null) {
            when ((params as? MultiItemsLayoutParams)?.position) {
                ItemPosition.LEFT -> {
                    binding?.layoutLeftItems?.apply {
                        removeAllViews()
                        addView(child, -1, params)
                    }
                }

                ItemPosition.RIGHT -> {
                    binding?.layoutRightItems?.apply {
                        removeAllViews()
                        addView(child, -1, params)
                    }
                }

                else -> {
                    binding?.layoutBottomItems?.apply {
                        removeAllViews()
                        addView(child, -1, params)
                    }
                }
            }
        }
    }

    override fun generateDefaultLayoutParams(): LayoutParams {
        return MultiItemsLayoutParams(context, null)
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MultiItemsLayoutParams(context, attrs)
    }

    private inner class MultiItemsLayoutParams(context: Context, attrs: AttributeSet?) : LayoutParams(context, attrs) {
        var position = ItemPosition.BOTTOM
            private set

        init {
            val typedArray = context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.MultiItemsLayout_Layout,
                0,
                0
            )

            try {
                position = ItemPosition.fromId(typedArray.getInt(R.styleable.MultiItemsLayout_Layout_layout_mil_itemPosition, position.id))
            } finally {
                typedArray.recycle()
            }
        }
    }

    enum class ItemPosition(val id: Int) {
        LEFT(0), RIGHT(1), BOTTOM(2);

        companion object {
            fun fromId(id: Int): ItemPosition {
                val position = values().firstOrNull { it.id == id }
                return when (position != null) {
                    true -> position
                    else -> BOTTOM
                }
            }
        }
    }
}

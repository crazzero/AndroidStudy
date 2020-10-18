package com.kwang0.layout.utils

import android.graphics.Color
import kotlin.math.max

class Utils {
    companion object {
        @JvmStatic
        fun addBlackMask(color: Int): Int {
            val hsv = FloatArray(3)
            Color.colorToHSV(color, hsv)
            hsv[2] = max(0f, hsv[2] - 0.2f)
            return Color.HSVToColor(hsv)
        }
    }
}
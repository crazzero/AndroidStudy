package com.kwang0.squircle_smooth_corner.layout

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.widget.FrameLayout
import kotlin.math.*

class BorderLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var mCenterX = 0f
    private var mCenterY = 0f
    private var mPaint: Paint? = null

    private var WIDTH = 400f
    private var HEIGHT = 400f
    private val SKETCH_ROUND_RECT_RADIUS = 100f

    private var ROUND_TL = true
    private  var ROUND_TR = true
    private  var ROUND_BL = true
    private  var ROUND_BR = true
    private var isSquare = false
        set(value) {
            field = value
            this.invalidate()
        }

    init {
        mPaint = Paint()
        mPaint!!.style = Paint.Style.FILL
        mPaint!!.strokeWidth = 12f
        mPaint!!.color = Color.rgb(253, 86, 85)
        this.setWillNotDraw(false)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mCenterX = w * 1.0f / 2
        mCenterY = h * 1.0f / 2
        WIDTH = if (isSquare) min(w, h).toFloat() else w.toFloat()
        HEIGHT = if (isSquare) min(w, h).toFloat() else h.toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        canvas.translate(0f, 0f)
        mPaint!!.isAntiAlias = true
        val path = if (isSquare) {
            sketchAllSmoothRect(
                0f, 0f, WIDTH, WIDTH, SKETCH_ROUND_RECT_RADIUS, SKETCH_ROUND_RECT_RADIUS,
                ROUND_TL, ROUND_TR, ROUND_BL, ROUND_BR
            )
        } else {
            sketchAllSmoothRect(
                0f, 0f, WIDTH, HEIGHT, SKETCH_ROUND_RECT_RADIUS, SKETCH_ROUND_RECT_RADIUS,
                ROUND_TL, ROUND_TR, ROUND_BL, ROUND_BR
            )
        }
        canvas.drawPath(path, mPaint!!)
        canvas.clipPath(path)
        super.onDraw(canvas)
    }

    private fun sketchAllSmoothRect(
        left: Float,
        top: Float,
        right: Float,
        bottom: Float,
        rx: Float,
        ry: Float,
        tl: Boolean,
        tr: Boolean,
        bl: Boolean,
        br: Boolean
    ): Path {
        var rx = rx
        var ry = ry
        val path = Path()
        if (rx < 0) rx = 0f
        if (ry < 0) ry = 0f
        val width = right - left
        val height = bottom - top
        val posX = mCenterX - width / 2
        val posY = mCenterY - height / 2
        if (width > height) {
            rx *= height / width
        } else {
            ry *= width / height
        }
        for (i in 0..3590000) {
            val j = (i / 10000).toFloat()
            val angle = (j * 2f * Math.PI / 360.0)
            val cosX = cos(angle.toDouble()).toFloat()
            val x = abs(cosX).toDouble().pow(rx / 100f.toDouble()).toFloat() * 50f * abs(cosX + 0.0000000001f) / (cosX + 0.0000000001f) + 50f
            val sinY = sin(angle.toDouble()).toFloat()
            val y = abs(sinY).toDouble().pow(ry / 100f.toDouble()).toFloat() * 50f * abs(sinY + 0.0000000001f) / (sinY + 0.0000000001f) + 50f
            val percentX = x / 100f
            val percentY = y / 100f
            if (j == 0f) path.moveTo(
                percentX * width + posX,
                percentY * height + posY
            ) else if (!br && i < 45) {
                path.lineTo(width + posX, height + posY)
            } else if (!br && i >= 45 && i < 90) {
                path.lineTo(posX + width / 2, height + posY)
            } else if (!bl && i >= 90 && i < 135) {
                path.lineTo(posX, height + posY)
            } else if (!bl && i >= 135 && i < 180) {
                path.lineTo(posX, height / 2 + posY)
            } else if (!tl && i >= 180 && i < 225) {
                path.lineTo(posX, posY)
            } else if (!tl && i >= 225 && i < 270) {
                path.lineTo(posX + width / 2, posY)
            } else if (!tr && i >= 270 && i < 315) {
                path.lineTo(posX + width, posY)
            } else if (!tr && i >= 315 && i < 360) {
                path.lineTo(posX + width, posY + height / 2)
            } else path.lineTo(percentX * width + posX, percentY * height + posY)
        }
        path.close()
        return path
    }

    fun getMAXRadius(width: Float, height: Float): Float {
        val minBorder = if (width > height) {
            height
        } else {
            width
        }
        return minBorder / 2f
    }

    private fun getRadiusInMaxRange(
        width: Float,
        height: Float,
        radius: Float
    ): Float {
        return min(radius, getMAXRadius(width, height))
    }
}

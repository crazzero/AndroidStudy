package com.kwang0.squircle_smooth_corner.layout

import android.content.Context
import android.graphics.*
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
    private var mContentPaint: Paint? = null

    private var WIDTH = 400f
    private var HEIGHT = 400f
    private val SKETCH_ROUND_RECT_RADIUS = 10f

    private var ROUND_TL = true
    private  var ROUND_TR = true
    private  var ROUND_BL = true
    private  var ROUND_BR = true

    init {
        mPaint = Paint()
        mPaint!!.style = Paint.Style.FILL
        mPaint!!.strokeWidth = 12f
        mPaint!!.isAntiAlias = true
        mPaint!!.color = Color.rgb(253, 86, 85)
        mContentPaint = Paint()
        mContentPaint!!.isAntiAlias = true
        mContentPaint!!.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mCenterX = w * 1.0f / 2
        mCenterY = h * 1.0f / 2
        WIDTH = w.toFloat()
        HEIGHT = h.toFloat()
    }

    override fun dispatchDraw(canvas: Canvas?) {
        if (canvas != null) {
            canvas.save()
            canvas.translate(0f, 0f)
            val path = sketchSmoothRect(
                0f,
                0f,
                WIDTH,
                HEIGHT,
                SKETCH_ROUND_RECT_RADIUS,
                SKETCH_ROUND_RECT_RADIUS,
                ROUND_TL,
                ROUND_TR,
                ROUND_BL,
                ROUND_BR
            )
            val contentPath = sketchSmoothRect(
                paddingLeft.toFloat(),
                paddingTop.toFloat(),
                WIDTH - paddingEnd.toFloat(),
                HEIGHT - paddingBottom.toFloat(),
                SKETCH_ROUND_RECT_RADIUS,
                SKETCH_ROUND_RECT_RADIUS,
                ROUND_TL,
                ROUND_TR,
                ROUND_BL,
                ROUND_BR
            )
            canvas.drawPath(path, mPaint!!)
            canvas.drawPath(contentPath, mContentPaint!!)
            canvas.clipPath(contentPath)

            super.dispatchDraw(canvas)
            canvas.restore()
        } else {
            super.dispatchDraw(canvas)
        }
    }

    private fun sketchSmoothRect(
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
        for (i in 0..359) {
            val j = i.toFloat()
            val angle = (j * 2f * Math.PI / 360.0)
            val cosX = cos(angle).toFloat()
            val x = abs(cosX.toDouble()).pow(rx / 100f.toDouble()).toFloat() * 50f * abs(cosX + 0.0000000001f) / (cosX + 0.0000000001f) + 50f
            val sinY = sin(angle).toFloat()
            val y = abs(sinY.toDouble()).pow(ry / 100f.toDouble()).toFloat() * 50f * abs(sinY + 0.0000000001f) / (sinY + 0.0000000001f) + 50f
            val percentX = x / 100f
            val percentY = y / 100f
            if (j == 0f) path.moveTo(
                percentX * width + posX,
                percentY * height + posY
            ) else if (!br && j < 45) {
                path.lineTo(width + posX, height + posY)
            } else if (!br && j >= 45 && j < 90) {
                path.lineTo(posX + width / 2, height + posY)
            } else if (!bl && j >= 90 && j < 135) {
                path.lineTo(posX, height + posY)
            } else if (!bl && j >= 135 && j < 180) {
                path.lineTo(posX, height / 2 + posY)
            } else if (!tl && j >= 180 && j < 225) {
                path.lineTo(posX, posY)
            } else if (!tl && j >= 225 && j < 270) {
                path.lineTo(posX + width / 2, posY)
            } else if (!tr && j >= 270 && j < 315) {
                path.lineTo(posX + width, posY)
            } else if (!tr && j >= 315 && j < 360) {
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

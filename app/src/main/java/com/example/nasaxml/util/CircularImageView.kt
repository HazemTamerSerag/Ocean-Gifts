package com.example.nasaxml.util

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.AttributeSet

class CircularImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : androidx.appcompat.widget.AppCompatImageView(context, attrs, defStyle) {

    private val paint = Paint()
    private val rectF = RectF()

    override fun onDraw(canvas: Canvas) {
        if (canvas != null) {
            val bitmap = drawableToBitmap(drawable)
            if (bitmap != null) {
                // Create a circular bitmap shader
                val shader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
                paint.shader = shader

                // Set the paint to draw a circle
                val radius = Math.min(width, height) / 2f
                rectF.set(0f, 0f, width.toFloat(), height.toFloat())
                canvas.drawCircle(width / 2f, height / 2f, radius, paint)
            }
        }
    }

    private fun drawableToBitmap(drawable: Drawable?): Bitmap? {
        if (drawable == null) return null

        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        return bitmap
    }
}
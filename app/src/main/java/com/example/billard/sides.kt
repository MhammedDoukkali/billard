package com.example.billard

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF


class sides (x1:Float, y1:Float, x2:Float, y2:Float) {
    val r = RectF(x1, y1, x2, y2)
    val paint = Paint()

    fun draw(canvas: Canvas) {
        paint.color = Color.GREEN
        canvas.drawRect(r, paint)
    }

    fun manageBall(b: Ball) {
        if (RectF.intersects(r, b.r)) {
            if(r.width() > r.height()) {
                b.changeDirection(true)
            }
            else {
                b.changeDirection(false)
            }
        }
    }
}
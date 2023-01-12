package com.example.billard

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.view.MotionEvent
import java.util.*

class Ball (x1: Float, y1: Float, val diametre: Float){
    val r = RectF(x1, y1, x1 + diametre, y1 + diametre)
    val random = Random()
    val paint = Paint()
    var color = Color.argb(255, random.nextInt(256),
    random.nextInt(256), random.nextInt(256))
    var showText = false
    var dx:Int
    var dy:Int

    init {
        if (random.nextDouble() > 0.5) dx = 1 else dx = -1
        if (random.nextDouble() < 0.5) dy = 1 else dy = -1
    }

    fun changeColor() {
        color = Color.argb(255, random.nextInt(256),
                           random.nextInt(256), random.nextInt(256))
    }
    fun draw (canvas: Canvas?) {
        paint.color = color
        canvas?.drawOval(r, paint)
//        if(showText) {
//            paint.textSize = 30f
//            canvas?.drawText("mon diametre est $diametre", r.left, r.top,
//                paint)
//        }
    }

    fun move(canvas: Canvas) {
        r.offset(5.0F * dx, 5.0F *dy)
        draw(canvas)
    }

}
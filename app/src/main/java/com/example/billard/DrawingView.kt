package com.example.billard


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceView
import java.util.*


class DrawingView @JvmOverloads constructor(context: Context,
attributes: AttributeSet? = null, defStyleAttr: Int = 0) :
SurfaceView(context, attributes, defStyleAttr), Runnable {

    val backgroundPaint = Paint()
    val random = Random()
    lateinit var thread: Thread
    var drawing = true
    lateinit var canvas: Canvas
    //Balls
    val b1 = Ball(random.nextFloat()*500, random.nextFloat()*1000,
              random.nextFloat()*500)
    val b2 = Ball(random.nextFloat()*500, random.nextFloat()*1000,
        random.nextFloat()*500)
    val b3 = Ball(random.nextFloat()*500, random.nextFloat()*1000,
        random.nextFloat()*500)

    fun changeColor() {
        b1.changeColor()
        b2.changeColor()
        b3.changeColor()
    }
    fun pause() {
        drawing = false
        thread.join()
    }

    fun resume() {
        thread = Thread(this)
        thread.start()
    }
    fun draw() {
        if (holder.surface.isValid) {
            canvas = holder.lockCanvas()
            backgroundPaint.color = Color.WHITE
            canvas.drawRect(0F, 0F, canvas.width*1F, canvas.height*1F, backgroundPaint)
            b1.move(canvas)
            holder.unlockCanvasAndPost(canvas)
        }
    }

//    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)
//        backgroundPaint.color = Color.WHITE
//        canvas?.drawRect(0f, 0f, width.toFloat(), height.toFloat(),
//                         backgroundPaint)
//        b1.draw(canvas)
//        b2.draw(canvas)
//        b3.draw(canvas)
//    }




    // MotionEvent report movement
    // onTouchEvent is to track click on the screen
//    override fun onTouchEvent(e: MotionEvent): Boolean {
//        if (e.action == MotionEvent.ACTION_DOWN) {
//            val x = e.rawX - 100
//            val y = e.rawY - 200
//            if(b1.r.contains(x, y)) b1.showText = true
//            else if (b2.r.contains(x, y)) b2.showText = true
//            else if (b3.r.contains(x, y)) b3.showText = true
//        }
//        //Force the update of the app
//        invalidate()
//        return true
//    }



    override fun run() {
        while (drawing) {
            draw()
        }
    }
}
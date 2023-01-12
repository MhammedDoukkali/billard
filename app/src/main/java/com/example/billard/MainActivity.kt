package com.example.billard

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast


class MainActivity : Activity() {

    lateinit var drawingView: DrawingView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawingView = findViewById<DrawingView>(R.id.vMain)
        drawingView.setWillNotDraw(false)
        drawingView.invalidate()
    }

    override fun onPause() {
        super.onPause()
        drawingView.pause()
    }

    override fun onResume() {
        super.onResume()
        drawingView.resume()
    }

    fun onClick(v: View) {
        drawingView.changeColor()
        drawingView.invalidate()
//            Toast.makeText(this, "I press my first button",
//                Toast.LENGTH_LONG).show()
    }
}


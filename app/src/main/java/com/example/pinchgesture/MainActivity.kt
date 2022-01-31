package com.example.pinchgesture

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.widget.ImageView


@SuppressLint("StaticFieldLeak")
lateinit var iv: ImageView
var scale = 1f


class MainActivity : AppCompatActivity() {


    var ourScaleDetector: ScaleGestureDetector? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iv = findViewById(R.id.idImage)
        ourScaleDetector = ScaleGestureDetector(this, ScaleListener())
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        ourScaleDetector!!.onTouchEvent(event)
        return super.onTouchEvent(event)
    }


    class ScaleListener: ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            scale *= detector.scaleFactor
            scale = Math.max(0.1f, Math.min(scale, 5.0f))
            iv.scaleX = scale
            iv.scaleY = scale
            return true
        }
    }


}


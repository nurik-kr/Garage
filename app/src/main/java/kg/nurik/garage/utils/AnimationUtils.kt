package kg.nurik.garage.utils

import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.ScaleAnimation

object AnimationUtils { // animation clickable button

    private const val DURATION = 300L

    fun animatePress(view: View) { // down
        val objectAnimation = ScaleAnimation(
            1f,
            0.8f,
            1f,
            0.8f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        objectAnimation.duration = DURATION
        objectAnimation.interpolator = LinearInterpolator()
        objectAnimation.fillAfter = true
        view.startAnimation(objectAnimation)
    }

    fun animateRelease(view: View) { // up
        val objectAnimation = ScaleAnimation(
            0.8f,
            1f,
            0.8f,
            1f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        objectAnimation.duration = DURATION
        objectAnimation.interpolator = LinearInterpolator()
        objectAnimation.fillAfter = true
        view.startAnimation(objectAnimation)
    }

    fun animateScale(view: View, ScaleFrom: Float, ScaleTo: Float) { //
        val maxScale = 100
        val minScale = 60

        val scaleFromFactor = (((maxScale - minScale) / 100f) * ScaleFrom + minScale) / 85
        val scaleToFactor = (((maxScale - minScale) / 100f) * ScaleTo + minScale) / 85

        val objectAnimation = ScaleAnimation(
            scaleFromFactor,
            scaleToFactor,
            scaleFromFactor,
            scaleToFactor,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        objectAnimation.interpolator = LinearInterpolator()
        objectAnimation.fillAfter = true
        view.startAnimation(objectAnimation)
    }

}
package com.oneflare.oneflaresnackbar

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.ContentViewCallback
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.OvershootInterpolator
import android.widget.ImageView

internal class OneflareSnackbarView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), ContentViewCallback {

    private val checkImage: ImageView

    init {
        View.inflate(context, R.layout.layout_oneflare_snackbar_view, this)
        clipToPadding = false
        this.checkImage = findViewById(R.id.check_image)
    }

    override fun animateContentIn(delay: Int, duration: Int) {
        Log.d("1234", "$checkImage")
        // we can add lottie here soon
        val scaleX = ObjectAnimator.ofFloat(checkImage, View.SCALE_X, 0f, 1f)
        val scaleY = ObjectAnimator.ofFloat(checkImage, View.SCALE_Y, 0f, 1f)
        val animatorSet = AnimatorSet().apply {
            interpolator = OvershootInterpolator()
            setDuration(500)
            playTogether(scaleX, scaleY)
        }
        animatorSet.start()
    }

    override fun animateContentOut(delay: Int, duration: Int) {
    }
}
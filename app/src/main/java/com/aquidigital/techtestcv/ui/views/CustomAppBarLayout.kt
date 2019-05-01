package com.aquidigital.techtestcv.ui.views

import android.animation.ObjectAnimator
import android.animation.StateListAnimator
import android.content.Context
import android.util.AttributeSet
import com.google.android.material.appbar.AppBarLayout

class CustomAppBarLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : AppBarLayout(context, attrs) {

    init {
        val stateListAnimator = StateListAnimator()
        stateListAnimator.addState(intArrayOf(0), ObjectAnimator.ofFloat(this, "elevation", 0.1f))
        setStateListAnimator(stateListAnimator)
    }
}
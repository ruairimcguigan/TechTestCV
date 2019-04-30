package com.aquidigital.techtestcv.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.aquidigital.techtestcv.R
import kotlinx.android.synthetic.main.retry_view.view.*

class CvRetryView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.retry_view, this)
    }

    fun populate(body: String) {
        error_retry_view_body.text = body
    }

}
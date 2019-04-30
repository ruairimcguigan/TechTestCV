package com.aquidigital.techtestcv.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.aquidigital.techtestcv.R
import com.aquidigital.techtestcv.api.AppLink

class AppLinksViewGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): LinearLayout(context, attrs, defStyleAttr) {

    init {
        orientation = LinearLayout.HORIZONTAL
    }

    fun populate(links: List<AppLink>) {
        removeAllViews()
        links.forEach { linksJson ->
            addView(with(AppLinkButton.create(linksJson, context)) {
                layoutParams = kotlin.with(
                    android.widget.LinearLayout.LayoutParams(
                        android.widget.LinearLayout.LayoutParams.WRAP_CONTENT,
                        android.widget.LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                ) {
                    marginEnd = context.resources.getDimensionPixelOffset(R.dimen.grid_8)
                    this
                }
                setOnClickListener {

                }
                this
            })
        }
    }
}
package com.aquidigital.techtestcv.ui.views

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams.WRAP_CONTENT
import com.aquidigital.techtestcv.R
import com.aquidigital.techtestcv.model.AppLink


class AppLinksViewGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): LinearLayout(context, attrs, defStyleAttr) {

    init {
        orientation = HORIZONTAL
    }

    fun populate(links: List<AppLink>) {
        removeAllViews()
        links.forEach { linksJson ->
            addView(with(AppLinkButton.create(linksJson, context)) {
                layoutParams = with(
                    LayoutParams(
                        WRAP_CONTENT,
                        WRAP_CONTENT
                    )
                ) {
                    marginEnd = context.resources.getDimensionPixelOffset(R.dimen.grid_8)
                    this
                }
                setOnClickListener {
                    openAppLink(links.first().url)
                }
                this
            })
        }
    }

    private fun openAppLink(appUrl: String) {
        // web link for demo - should deep link to store
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(appUrl)
        context.startActivity(i)
    }
}
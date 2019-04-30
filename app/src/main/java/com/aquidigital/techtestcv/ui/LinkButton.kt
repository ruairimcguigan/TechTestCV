package com.aquidigital.techtestcv.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.AppCompatButton
import com.aquidigital.techtestcv.R
import com.aquidigital.techtestcv.api.AppLink

class AppLinkButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.style.LinkButton
) : AppCompatButton(context, attrs, defStyleAttr) {

    lateinit var link: AppLink

    fun populate(link: AppLink) {
        this.link = link
        text = link.name
    }

    companion object {
        fun create(appLink: AppLink, context: Context): AppLinkButton {
            return with(
                LayoutInflater.from(context).inflate(
                    R.layout.app_link_item,
                    null,
                    false) as AppLinkButton) {
                populate(appLink)
                this
            }
        }
    }
}
package com.aquidigital.techtestcv.ui.cv

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.RecyclerView
import com.aquidigital.techtestcv.model.Experience
import kotlinx.android.synthetic.main.experience_item_view.view.*

class CvExperienceViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val title = view.experienceTitleLabel
    private val subTitle = view.experienceSubtitleLabel
    private val description = view.experienceDescriptionLabel
    private val appLinksView = view.experienceLinksViewGroup

    fun populate(experience: Experience) {
        title.text = experience.title
        subTitle.text = experience.dateRange
        description.text = experience.description

        if (experience.links.isNotEmpty()) {
            appLinksView.visibility = VISIBLE
            appLinksView.populate(experience.links)
        } else {
            appLinksView.visibility = GONE
        }
    }
}
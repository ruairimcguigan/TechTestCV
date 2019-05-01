package com.aquidigital.techtestcv.ui.cv

import android.view.View
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

        // TODO to complete
//        if (experience.appLinks.isNotEmpty()) {
//            appLinksView.visibility = VISIBLE
//            appLinksView.populate(experience.appLinks)
//        } else {
//            appLinksView.visibility = GONE
//        }
    }
}
package com.aquidigital.techtestcv.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aquidigital.techtestcv.R
import com.aquidigital.techtestcv.api.Experience
import javax.inject.Inject

class CvExperienceAdapter @Inject constructor() : RecyclerView.Adapter<CvExperienceViewHolder>() {

    var data: MutableList<Experience> = ArrayList()

    fun populate(experience: List<Experience>) {
        data.clear()
        data.addAll(experience)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CvExperienceViewHolder {

        val view = LayoutInflater.from(
            parent.context
        ).inflate(
            R.layout.experience_item_view,
            parent,
            false
        )
        return CvExperienceViewHolder(view)
    }

    override fun onBindViewHolder(holder: CvExperienceViewHolder, position: Int) {
        holder.populate(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
package com.aquidigital.techtestcv.ui.cv

import androidx.lifecycle.ViewModel
import com.aquidigital.techtestcv.api.Api
import com.aquidigital.techtestcv.repo.CvRepository
import javax.inject.Inject

class CvViewModel
@Inject constructor(private val repo: CvRepository) : ViewModel() {

    fun getCv() = repo.fetchCv()
}
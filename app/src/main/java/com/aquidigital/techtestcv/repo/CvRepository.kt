package com.aquidigital.techtestcv.repo

import com.aquidigital.techtestcv.api.Api
import javax.inject.Inject

open class CvRepository
@Inject constructor(private val api: Api) {

    fun fetchCv() = api.getCv()
}
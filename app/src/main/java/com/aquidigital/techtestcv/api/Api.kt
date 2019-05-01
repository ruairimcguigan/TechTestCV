package com.aquidigital.techtestcv.api

import androidx.lifecycle.LiveData
import com.aquidigital.techtestcv.model.CV
import retrofit2.http.GET

interface Api {

    @GET("bins/18jdco") fun getCv(): LiveData<ApiResponse<CV>>
}
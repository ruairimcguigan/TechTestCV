package com.aquidigital.techtestcv.api

import androidx.lifecycle.LiveData
import com.aquidigital.techtestcv.model.CV
import retrofit2.http.GET

interface Api {

    @GET("bins/ufagg") fun getCv(): LiveData<ApiResponse<CV>>
}
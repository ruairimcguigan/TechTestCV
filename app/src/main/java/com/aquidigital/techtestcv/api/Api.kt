package com.aquidigital.techtestcv.api

import androidx.lifecycle.LiveData
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("bins/ufagg")
    fun getCv(): LiveData<Response<CvJson>>
}
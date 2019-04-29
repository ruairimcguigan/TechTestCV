package com.aquidigital.techtestcv.api

import okhttp3.Interceptor

data class ApiConfig(
    val interceptors: List<Interceptor> = emptyList()
)
package com.aquidigital.techtestcv

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response

public class StubInterceptor(
    private val stub: Stub,
    context: Context,
    private val stubApi: StubApi = StubApi(context)
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return stubApi.handle(stub, chain.request())
    }
}
package com.aquidigital.techtestcv.app

import com.aquidigital.techtestcv.Stub
import com.aquidigital.techtestcv.StubInterceptor
import com.aquidigital.techtestcv.api.ApiConfig
import com.aquidigital.techtestcv.inject.AppComponent
import com.aquidigital.techtestcv.inject.BaseApplication
import com.aquidigital.techtestcv.inject.DaggerAppComponent
import java.util.Arrays.asList

public class InjectorApplication : BaseApplication() {

    override val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .apiConfig(ApiConfig(asList(StubInterceptor(Stub.Success, this))))
            .application(this)
            .build()
    }
}
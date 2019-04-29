package com.aquidigital.techtestcv.app

import com.aquidigital.techtestcv.api.ApiConfig
import com.aquidigital.techtestcv.inject.AppComponent
import com.aquidigital.techtestcv.inject.BaseApplication
import com.aquidigital.techtestcv.inject.DaggerAppComponent

class InjectApplication: BaseApplication() {

    override val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .apiConfig(ApiConfig())
            .application(this)
            .build()
    }
}
package com.aquidigital.techtestcv.inject

import com.aquidigital.techtestcv.Stub
import com.aquidigital.techtestcv.StubInterceptor
import com.aquidigital.techtestcv.api.ApiConfig
import dagger.android.AndroidInjector
import java.util.Arrays.asList

class TestInjectApplication : BaseApplication() {

    override fun onCreate() {
        instance = this
        super.onCreate()
    }

    private fun inject() {
        applicationInjector().inject(this)
    }

    override fun applicationInjector(): AndroidInjector<BaseApplication> {
        return androidInjector ?: super.applicationInjector()
    }


    override val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .apiConfig(ApiConfig(asList(StubInterceptor(Stub.Success, this))))
            .application(this)
            .build()
    }

    companion object {

        lateinit var instance: TestInjectApplication
        private var androidInjector: AndroidInjector<BaseApplication>? = null

        fun setInjector(injector: AndroidInjector<BaseApplication>) {
            androidInjector = injector
            instance.inject()
        }

        fun resetInjector() {
            androidInjector = null
            instance.inject()
        }
    }
}
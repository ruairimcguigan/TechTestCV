package com.aquidigital.techtestcv.testrule

import android.app.Application
import androidx.test.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.aquidigital.techtestcv.Stub
import com.aquidigital.techtestcv.StubInterceptor
import com.aquidigital.techtestcv.api.ApiConfig
import com.aquidigital.techtestcv.inject.DaggerAppComponent
import com.aquidigital.techtestcv.inject.TestInjectApplication
import com.aquidigital.techtestcv.ui.CvActivity
import java.util.*

class ActivityTestRule : ActivityTestRule<CvActivity>(
    CvActivity::class.java,
    true,
    false
) {

    private lateinit var stub: Stub

    fun launch(stub: Stub) {
        this.stub = stub
        launchActivity(null)
    }

    private fun inject() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as Application
        val injector = DaggerAppComponent
            .builder()
            .apiConfig(ApiConfig(Arrays.asList(StubInterceptor(stub, context))))
            .application(context)
            .build()

        TestInjectApplication.setInjector(injector)
    }

    override fun beforeActivityLaunched() {
        super.beforeActivityLaunched()
        inject()
    }

    override fun afterActivityFinished() {
        super.afterActivityFinished()
        TestInjectApplication.resetInjector()
    }
}
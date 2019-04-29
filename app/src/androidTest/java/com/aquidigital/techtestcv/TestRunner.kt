package com.aquidigital.techtestcv

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.aquidigital.techtestcv.inject.TestInjectApplication

class TestRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        return super.newApplication(cl, TestInjectApplication::class.java.name, context)
    }
}
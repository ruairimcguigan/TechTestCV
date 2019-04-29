package com.aquidigital.techtestcv.inject

import android.app.Activity
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

abstract class BaseApplication : DaggerApplication() {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun applicationInjector(): AndroidInjector<BaseApplication> = appComponent

    override fun activityInjector(): DispatchingAndroidInjector<Activity> = activityInjector

    abstract val appComponent: AppComponent
}
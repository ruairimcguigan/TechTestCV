package com.aquidigital.techtestcv.inject

import android.app.Application
import android.content.Context
import com.aquidigital.techtestcv.ui.CvActivity
import com.aquidigital.techtestcv.ui.UiModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(app: Application): Context

    @ContributesAndroidInjector(modules = [UiModule::class])
    internal abstract fun contributeCvActivity(): CvActivity
}
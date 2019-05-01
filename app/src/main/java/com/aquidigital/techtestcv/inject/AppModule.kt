package com.aquidigital.techtestcv.inject

import android.app.Application
import android.content.Context
import com.aquidigital.techtestcv.ui.cv.CvActivity
import com.aquidigital.techtestcv.ui.viewmodel.ViewModelModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(app: Application): Context

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    internal abstract fun contributeCvActivity(): CvActivity
}
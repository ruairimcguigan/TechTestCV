package com.aquidigital.techtestcv.inject

import androidx.appcompat.app.AppCompatActivity
import com.aquidigital.techtestcv.ui.UiModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector(modules = [UiModule::class])
    internal abstract fun contributeCvActivity(): AppCompatActivity
}
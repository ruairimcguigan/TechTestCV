package com.aquidigital.techtestcv.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aquidigital.techtestcv.ui.cv.CvViewModel
import com.aquidigital.techtestcv.ui.viewmodel.ViewModelFactory
import com.aquidigital.techtestcv.ui.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CvViewModel::class)
    internal abstract fun contributesCvViewModel(viewModel: CvViewModel): ViewModel
}
package com.aquidigital.techtestcv.ui

import androidx.lifecycle.AndroidViewModel
import com.aquidigital.techtestcv.inject.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class UiModule {

    @Binds
    @IntoMap
    @ViewModelKey(CvViewModel::class)
    internal abstract fun contributesCvViewModel(viewModel: CvViewModel): AndroidViewModel
}
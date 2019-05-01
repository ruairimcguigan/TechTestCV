package com.aquidigital.techtestcv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aquidigital.techtestcv.repo.CvRepository
import com.aquidigital.techtestcv.ui.cv.CvViewModel
import com.nhaarman.mockito_kotlin.mock
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class CvViewModelTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private val repo = mock(CvRepository::class.java)
    private val viewModel = CvViewModel(repo)

    @Test
    fun testCallRepo() {
        viewModel.getCv().observeForever(mock())
        viewModel.getCv()
        Mockito.verify(repo).fetchCv()
    }
}

package com.aquidigital.techtestcv.ui

import android.os.Bundle
import android.view.Window
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.aquidigital.techtestcv.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.content_cv.*
import javax.inject.Inject

class CvActivity : AppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelFactory
    @Inject lateinit var adapter: CvExperienceAdapter

    private lateinit var viewmodel: CvViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setImmersive()
        setContentView(R.layout.activity_cv)
        inject()
        initCvList()
    }

    override fun onStart() {
        super.onStart()
        observeViewModel()
        fetchCV()
    }

    private fun observeViewModel() {
        viewmodel = ViewModelProviders.of(
            this,
            viewModelFactory)
            .get(CvViewModel::class.java)
    }

    private fun initCvList() {
        experienceListView.layoutManager = LinearLayoutManager(this)
        experienceListView.adapter = adapter
    }

    private fun fetchCV() {
        viewmodel.getCV()
    }

    private fun setImmersive() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)
    }

    private fun inject() {
        AndroidInjection.inject(this)
    }
}

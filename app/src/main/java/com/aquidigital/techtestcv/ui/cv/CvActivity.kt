package com.aquidigital.techtestcv.ui.cv

import android.os.Bundle
import android.view.View.*
import android.view.Window
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.aquidigital.techtestcv.R
import com.aquidigital.techtestcv.model.CV
import com.aquidigital.techtestcv.ui.viewmodel.ViewModelFactory
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
        viewmodel.getCv().observe(this, Observer { setCV(it.body) })
    }

    private fun setCV(cv: CV?) {
        progressBar.visibility = GONE

        if (cv != null) {
            nameView.text = cv.name
            jobTitleView.text = cv.title
            profileView.text = cv.description

            adapter.populate(cv.experience)
        }
    }

    private fun setImmersive() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)
    }

    private fun inject() {
        AndroidInjection.inject(this)
    }
}

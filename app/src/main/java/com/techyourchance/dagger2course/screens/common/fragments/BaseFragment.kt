package com.example.daggertwo.screens.common.fragments

import androidx.fragment.app.Fragment
import com.example.daggertwo.common.dependencyinjection.activity.DaggerActivityComponent
import com.example.daggertwo.common.dependencyinjection.presentation.DaggerPresentationComponent
import com.example.daggertwo.common.dependencyinjection.presentation.PresentationModule
import com.example.daggertwo.screens.common.activities.BaseActivity

open class BaseFragment: Fragment() {

    val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .activityComponent((requireActivity() as BaseActivity).activityComponent)
            .presentationModule(PresentationModule())
            .build()
    }
    protected val injector get() = presentationComponent
}
package com.example.daggertwo.screens.common.fragments

import androidx.fragment.app.Fragment
import com.example.daggertwo.common.dependencyinjection.presentation.PresentationModule
import com.example.daggertwo.screens.common.activities.BaseActivity

open class BaseFragment: Fragment() {

    val presentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent.newPresentationComponent(PresentationModule())
    }
    protected val injector get() = presentationComponent
}
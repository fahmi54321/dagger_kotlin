package com.example.daggertwo.screens.common.fragments

import androidx.fragment.app.Fragment
import com.example.daggertwo.screens.common.activities.BaseActivity

open class BaseFragment: Fragment() {

    val presentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent.newPresentationComponent(
            (requireActivity() as BaseActivity).presentationModule,
            (requireActivity() as BaseActivity).useCaseModule,
        )
    }
    protected val injector get() = presentationComponent
}
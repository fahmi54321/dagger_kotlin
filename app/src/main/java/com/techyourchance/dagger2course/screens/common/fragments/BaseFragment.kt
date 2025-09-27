package com.techyourchance.dagger2course.screens.common.fragments

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.compisition.ActivityCompositionRoot
import com.techyourchance.dagger2course.common.compisition.PresentationCompositionRoot
import com.techyourchance.dagger2course.screens.common.activities.BaseActivity

open class BaseFragment: Fragment() {
    protected val compositionRoot by lazy {
        PresentationCompositionRoot((requireActivity() as BaseActivity).activityCompositionRoot)
    }
}
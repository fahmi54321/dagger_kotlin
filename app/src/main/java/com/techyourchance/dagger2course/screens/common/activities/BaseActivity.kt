package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.dependencyinjection.ActivityCompositionRoot
import com.techyourchance.dagger2course.common.dependencyinjection.Injector
import com.techyourchance.dagger2course.common.dependencyinjection.PresentationCompositionRoot

open class BaseActivity: AppCompatActivity() {
    private val appCompisitionRoot get() = (application as MyApplication).appCompositionRoot
    val activityCompositionRoot by lazy {
        ActivityCompositionRoot(this, appCompisitionRoot);
    }
    private val compositionRoot by lazy {
        PresentationCompositionRoot(activityCompositionRoot)
    }

    val injector get() = Injector(compositionRoot)
}
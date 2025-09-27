package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.compisition.ActivityCompositionRoot
import com.techyourchance.dagger2course.common.compisition.PresentationCompositionRoot

open class BaseActivity: AppCompatActivity() {
    private val appCompisitionRoot get() = (application as MyApplication).appCompositionRoot
    val activityCompositionRoot by lazy {
        ActivityCompositionRoot(this, appCompisitionRoot);
    }
    protected val compositionRoot by lazy {
        PresentationCompositionRoot(activityCompositionRoot)
    }
}
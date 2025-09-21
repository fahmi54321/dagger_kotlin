package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.compisition.ActivityCompositionRoot

open class BaseActivity: AppCompatActivity() {
    private val appCompisitionRoot get() = (application as MyApplication).appCompositionRoot
    val compositionRoot by lazy {   ActivityCompositionRoot(this, appCompisitionRoot)}
}
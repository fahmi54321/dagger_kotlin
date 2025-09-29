package com.techyourchance.dagger2course.common.dependencyinjection

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.screens.common.ScreensNavigator

class ActivityCompositionRoot(
    val activity: AppCompatActivity,
    private val appCompisitionRoot: AppCompisitionRoot,
) {
    val screensNavigator by lazy {
        ScreensNavigator(activity)
    }

    val application get() = appCompisitionRoot.application

    val fragmentManager get() = activity.supportFragmentManager

    val layoutInflater get() = LayoutInflater.from(activity.applicationContext)

    val stackoverflowApi get() = appCompisitionRoot.stackoverflowApi

}
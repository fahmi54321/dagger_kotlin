package com.techyourchance.dagger2course.common.dependencyinjection

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
    val activity: AppCompatActivity,
    private val appComponent: AppComponent,
) {

    private val screensNavigator by lazy {
        ScreensNavigator(activity)
    }

    @Provides
    fun activity() = activity

    @Provides
    fun screensNavigator() = screensNavigator

    @Provides
    fun application() = appComponent.application()

    @Provides
    fun fragmentManager() = activity.supportFragmentManager

    @Provides
    fun layoutInflater() = LayoutInflater.from(activity.applicationContext)

    @Provides
    fun stackoverflowApi() = appComponent.stackoverflowApi()

}
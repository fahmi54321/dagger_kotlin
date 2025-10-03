package com.techyourchance.dagger2course.common.dependencyinjection.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.common.dependencyinjection.app.AppComponent
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
    val activity: AppCompatActivity,
    private val appComponent: AppComponent,
) {

    @Provides
    fun activity() = activity

    @ActivityScope
    @Provides
    fun screensNavigator() = ScreensNavigator(activity)

    @Provides
    fun application() = appComponent.application()

    @Provides
    fun fragmentManager() = activity.supportFragmentManager

    @Provides
    fun layoutInflater() = LayoutInflater.from(activity.applicationContext)

    @Provides
    fun stackoverflowApi() = appComponent.stackoverflowApi()

}
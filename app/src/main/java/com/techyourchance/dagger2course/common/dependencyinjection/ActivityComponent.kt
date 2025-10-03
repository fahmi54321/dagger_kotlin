package com.techyourchance.dagger2course.common.dependencyinjection

import android.app.Application
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import dagger.Component
import dagger.Provides

@Component(modules = [ActivityModule::class])
interface ActivityComponent {
    fun screensNavigator() : ScreensNavigator

    fun application(): Application

    fun activity(): AppCompatActivity

    fun fragmentManager() : FragmentManager

    fun layoutInflater() : LayoutInflater

    fun stackoverflowApi() : StackoverflowApi
}
package com.example.daggertwo.common.dependencyinjection.activity

import android.app.Application
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.daggertwo.common.dependencyinjection.app.AppComponent
import com.example.daggertwo.networking.StackoverflowApi
import com.example.daggertwo.screens.common.ScreensNavigator
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class],modules = [ActivityModule::class])
interface ActivityComponent {
    fun screensNavigator() : ScreensNavigator

    fun application(): Application

    fun activity(): AppCompatActivity

    fun fragmentManager() : FragmentManager

    fun layoutInflater() : LayoutInflater

    fun stackoverflowApi() : StackoverflowApi
}
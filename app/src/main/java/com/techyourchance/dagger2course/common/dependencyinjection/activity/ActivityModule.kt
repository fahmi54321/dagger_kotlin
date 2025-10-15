package com.example.daggertwo.common.dependencyinjection.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.daggertwo.screens.common.ScreensNavigator
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {
    companion object{
        @Provides
        @ActivityScope
        fun screenNavigator(activity: AppCompatActivity) = ScreensNavigator(activity)

        @Provides
        fun fragmentManager(activity: AppCompatActivity) = activity.supportFragmentManager

        @Provides
        fun layoutInflater(activity: AppCompatActivity) =
            LayoutInflater.from(activity.applicationContext)
    }
}
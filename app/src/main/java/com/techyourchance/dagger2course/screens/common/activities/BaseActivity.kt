package com.example.daggertwo.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.example.daggertwo.MyApplication
import com.example.daggertwo.common.dependencyinjection.activity.ActivityModule

open class BaseActivity: AppCompatActivity() {

    private val appComponent get() = (application as MyApplication).appComponent

    private val activityModule by lazy {
        ActivityModule();
    }

    val activityComponent by lazy {
        appComponent.newActivityComponentBuilder()
            .activity(this)
            .activityModule(activityModule)
            .build()
    }


    private val presentationComponent by lazy {
        activityComponent.newPresentationComponent()
    }
    val injector get() = presentationComponent
}
package com.example.daggertwo.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.example.daggertwo.common.dependencyinjection.activity.ActivityModule
import com.example.daggertwo.common.dependencyinjection.app.AppModule
import com.example.daggertwo.common.dependencyinjection.app.DaggerAppComponent

open class BaseActivity: AppCompatActivity() {

    private val appComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(application))
            .build()
    }

    private val activityModule by lazy {
        ActivityModule(this);
    }

    val activityComponent by lazy {
        appComponent.newActivityComponent(activityModule)
    }


    private val presentationComponent by lazy {
        activityComponent.newPresentationComponent()
    }
    val injector get() = presentationComponent
}
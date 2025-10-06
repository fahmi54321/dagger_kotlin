package com.example.daggertwo.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.example.daggertwo.MyApplication
import com.example.daggertwo.common.dependencyinjection.activity.ActivityModule
import com.example.daggertwo.common.dependencyinjection.app.AppModule
import com.example.daggertwo.common.dependencyinjection.activity.DaggerActivityComponent
import com.example.daggertwo.common.dependencyinjection.app.DaggerAppComponent
import com.example.daggertwo.common.dependencyinjection.presentation.DaggerPresentationComponent
import com.example.daggertwo.common.dependencyinjection.presentation.PresentationModule

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
        DaggerActivityComponent.builder()
            .appComponent(appComponent)
            .activityModule(activityModule)
            .build()
    }


    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .activityComponent(activityComponent)
            .presentationModule(PresentationModule())
            .build()
    }
    val injector get() = presentationComponent
}
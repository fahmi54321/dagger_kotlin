package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.dependencyinjection.ActivityModule
import com.techyourchance.dagger2course.common.dependencyinjection.AppModule
import com.techyourchance.dagger2course.common.dependencyinjection.DaggerActivityComponent
import com.techyourchance.dagger2course.common.dependencyinjection.DaggerAppComponent
import com.techyourchance.dagger2course.common.dependencyinjection.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.dependencyinjection.Injector
import com.techyourchance.dagger2course.common.dependencyinjection.PresentationModule

open class BaseActivity: AppCompatActivity() {
    private val appCompisitionRoot get() = (application as MyApplication).appCompositionRoot

    private val appComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(application))
            .build()
    }

    val activityModule by lazy {
        ActivityModule(this, appComponent);
    }

    private val activityComponent by lazy {
        DaggerActivityComponent.builder()
            .activityModule(activityModule)
            .build()
    }


    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule(activityComponent))
            .build()
    }
    val injector get() = Injector(presentationComponent)
}
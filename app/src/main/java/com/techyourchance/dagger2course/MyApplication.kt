package com.techyourchance.dagger2course

import android.app.Application
import com.techyourchance.dagger2course.common.dependencyinjection.app.AppModule

class MyApplication: Application() {

    lateinit var appCompositionRoot: AppModule

    override fun onCreate() {
        appCompositionRoot = AppModule(this)
        super.onCreate()
    }
}
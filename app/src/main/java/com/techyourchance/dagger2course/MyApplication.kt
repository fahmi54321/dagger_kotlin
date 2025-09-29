package com.techyourchance.dagger2course

import android.app.Application
import com.techyourchance.dagger2course.common.dependencyinjection.AppCompisitionRoot

class MyApplication: Application() {

    lateinit var appCompositionRoot: AppCompisitionRoot

    override fun onCreate() {
        appCompositionRoot = AppCompisitionRoot(this)
        super.onCreate()
    }
}
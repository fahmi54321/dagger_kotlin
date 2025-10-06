package com.example.daggertwo

import android.app.Application
import com.example.daggertwo.common.dependencyinjection.app.AppModule

class MyApplication: Application() {

    lateinit var appCompositionRoot: AppModule

    override fun onCreate() {
        appCompositionRoot = AppModule(this)
        super.onCreate()
    }
}
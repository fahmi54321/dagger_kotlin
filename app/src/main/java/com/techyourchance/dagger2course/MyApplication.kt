package com.example.daggertwo

import android.app.Application
import com.example.daggertwo.common.dependencyinjection.app.AppComponent
import com.example.daggertwo.common.dependencyinjection.app.AppModule
import com.example.daggertwo.common.dependencyinjection.app.DaggerAppComponent

class MyApplication: Application() {
    public val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}
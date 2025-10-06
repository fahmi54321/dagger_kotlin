package com.example.daggertwo.common.dependencyinjection.app

import android.app.Application
import com.example.daggertwo.networking.StackoverflowApi
import dagger.Component
import javax.inject.Singleton

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    fun stackoverflowApi(): StackoverflowApi

    fun application() : Application
}
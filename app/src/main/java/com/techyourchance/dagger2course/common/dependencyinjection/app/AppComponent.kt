package com.example.daggertwo.common.dependencyinjection.app

import com.example.daggertwo.common.dependencyinjection.activity.ActivityComponent
import com.example.daggertwo.common.dependencyinjection.activity.ActivityModule
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    fun newActivityComponentBuilder(): ActivityComponent.Builder
}
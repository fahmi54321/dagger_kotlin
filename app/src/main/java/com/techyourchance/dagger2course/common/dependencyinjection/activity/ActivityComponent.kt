package com.example.daggertwo.common.dependencyinjection.activity

import com.example.daggertwo.common.dependencyinjection.presentation.PresentationComponent
import com.example.daggertwo.common.dependencyinjection.presentation.PresentationModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun newPresentationComponent(presentationModule: PresentationModule): PresentationComponent
}
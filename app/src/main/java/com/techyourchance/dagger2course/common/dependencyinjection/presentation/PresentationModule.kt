package com.example.daggertwo.common.dependencyinjection.presentation

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.example.daggertwo.networking.StackoverflowApi
import com.example.daggertwo.questions.FetchQuestionDetailsUseCase
import com.example.daggertwo.questions.FetchQuestionUseCase
import com.example.daggertwo.screens.common.dialogs.DialogsNavigator
import com.example.daggertwo.screens.common.viewsmvc.ViewMvcFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {

    @Provides
    fun viewMvcFactory(layoutInflater: LayoutInflater) = ViewMvcFactory(layoutInflater)

    @Provides
    fun dialogsNavigator(fragmentManager: FragmentManager) = DialogsNavigator(fragmentManager)

    @Provides
    fun fetchQuestionUseCase(stackoverflowApi: StackoverflowApi) = FetchQuestionUseCase(stackoverflowApi)

    @Provides
    fun fetchQuestionDetailsUseCase(stackoverflowApi: StackoverflowApi) = FetchQuestionDetailsUseCase(stackoverflowApi)
}
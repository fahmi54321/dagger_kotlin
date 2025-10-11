package com.example.daggertwo.common.dependencyinjection.presentation

import com.example.daggertwo.networking.StackoverflowApi
import com.example.daggertwo.questions.FetchQuestionDetailsUseCase
import com.example.daggertwo.questions.FetchQuestionUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun fetchQuestionUseCase(stackoverflowApi: StackoverflowApi) = FetchQuestionUseCase(stackoverflowApi)

    @Provides
    fun fetchQuestionDetailsUseCase(stackoverflowApi: StackoverflowApi) = FetchQuestionDetailsUseCase(stackoverflowApi)
}
package com.example.daggertwo.common.dependencyinjection.presentation

import com.example.daggertwo.common.dependencyinjection.activity.ActivityComponent
import com.example.daggertwo.common.dependencyinjection.app.PresentationScope
import com.example.daggertwo.questions.FetchQuestionDetailsUseCase
import com.example.daggertwo.questions.FetchQuestionUseCase
import com.example.daggertwo.screens.common.ScreensNavigator
import com.example.daggertwo.screens.common.dialogs.DialogsNavigator
import com.example.daggertwo.screens.common.viewsmvc.ViewMvcFactory
import com.example.daggertwo.screens.questiondetails.QuestionDetailsFragment
import com.example.daggertwo.screens.questionslist.QuestionsListFragment
import dagger.Component

@PresentationScope
@Component(dependencies = [ActivityComponent::class],modules = [PresentationModule::class])
interface PresentationComponent {
    fun inject(fragment: QuestionsListFragment)
    fun inject(fragment: QuestionDetailsFragment)
}
package com.example.daggertwo.common.dependencyinjection.presentation

import com.example.daggertwo.common.dependencyinjection.app.PresentationScope
import com.example.daggertwo.screens.questiondetails.QuestionDetailsFragment
import com.example.daggertwo.screens.questionslist.QuestionsListFragment
import com.techyourchance.dagger2course.common.dependencyinjection.presentation.ViewModelsModule
import com.techyourchance.dagger2course.screens.common.imageloader.ImageLoader
import com.techyourchance.dagger2course.screens.questionslistviewmodel.QuestionsListViewModelActivity
import com.techyourchance.dagger2course.screens.viewmodel.ViewModelActivity
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [ViewModelsModule::class])
interface PresentationComponent {
    fun inject(fragment: QuestionsListFragment)
    fun inject(fragment: QuestionDetailsFragment)
    fun inject(viewModelActivity: ViewModelActivity)
    fun inject(questionsListViewModelActivity: QuestionsListViewModelActivity)
}
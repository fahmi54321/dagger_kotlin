package com.example.daggertwo.common.dependencyinjection.presentation

import com.example.daggertwo.common.dependencyinjection.app.PresentationScope
import com.example.daggertwo.screens.questiondetails.QuestionDetailsFragment
import com.example.daggertwo.screens.questionslist.QuestionsListFragment
import com.techyourchance.dagger2course.screens.common.imageloader.ImageLoader
import dagger.Subcomponent

@PresentationScope
@Subcomponent
interface PresentationComponent {
    fun inject(fragment: QuestionsListFragment)
    fun inject(fragment: QuestionDetailsFragment)
}
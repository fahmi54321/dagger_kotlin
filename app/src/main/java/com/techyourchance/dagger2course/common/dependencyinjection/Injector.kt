package com.techyourchance.dagger2course.common.dependencyinjection

import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsFragment
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListFragment

class Injector(private val compositionRoot: PresentationCompositionRoot) {
    fun inject(fragment: QuestionsListFragment) {
        fragment.dialogsNavigator = compositionRoot.dialogsNavigator
        fragment.screensNavigator = compositionRoot.screensNavigator
        fragment.fetchQuestionUseCase = compositionRoot.fetchQuestionUseCase
        fragment.viewMvcFactory = compositionRoot.viewMvcFactory
    }

    fun inject(fragment: QuestionDetailsFragment) {
        fragment.dialogsNavigator = compositionRoot.dialogsNavigator
        fragment.screensNavigator = compositionRoot.screensNavigator
        fragment.fetchQuestionDetailsUseCase = compositionRoot.fetchQuestionDetailsUseCase
        fragment.viewMvcFactory = compositionRoot.viewMvcFactory
    }
}
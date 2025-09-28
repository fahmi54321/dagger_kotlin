package com.techyourchance.dagger2course.common.compisition

import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionUseCase
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMvcFactory

class PresentationCompositionRoot(private val activityCompositionRoot: ActivityCompositionRoot) {

    private val layoutInflater get() = activityCompositionRoot.layoutInflater
    private val fragmentManager get() = activityCompositionRoot.fragmentManager
    private val stackoverflowApi get() = activityCompositionRoot.stackoverflowApi
    private val activity get() = activityCompositionRoot.activity

    val viewMvcFactory get() = ViewMvcFactory(layoutInflater)
    val dialogsNavigator get() = DialogsNavigator(fragmentManager)
    val screensNavigator get() = activityCompositionRoot.screensNavigator
    val fetchQuestionUseCase get() = FetchQuestionUseCase(stackoverflowApi)
    val fetchQuestionDetailsUseCase get() = FetchQuestionDetailsUseCase(stackoverflowApi)
}
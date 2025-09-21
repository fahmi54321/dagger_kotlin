package com.techyourchance.dagger2course.common.compisition

import android.app.Activity
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionUseCase
import com.techyourchance.dagger2course.screens.common.ScreensNavigator

class ActivityCompositionRoot(
    private val activity: Activity,
    private val appCompisitionRoot: AppCompisitionRoot
) {
    val screensNavigator by lazy {
        ScreensNavigator(activity)
    }

    private val stackoverflowApi get() = appCompisitionRoot.stackoverflowApi

    val fetchQuestionUseCase get() = FetchQuestionUseCase(stackoverflowApi)
    val fetchQuestionDetailsUseCase get() = FetchQuestionDetailsUseCase(stackoverflowApi)
}
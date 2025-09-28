package com.techyourchance.dagger2course.common.compisition

import android.app.Activity
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionUseCase
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMvcFactory

class ActivityCompositionRoot(
    val activity: AppCompatActivity,
    private val appCompisitionRoot: AppCompisitionRoot,
) {
    val screensNavigator by lazy {
        ScreensNavigator(activity)
    }

    val application get() = appCompisitionRoot.application

    val fragmentManager get() = activity.supportFragmentManager

    val layoutInflater get() = LayoutInflater.from(activity.applicationContext)

    val stackoverflowApi get() = appCompisitionRoot.stackoverflowApi

}
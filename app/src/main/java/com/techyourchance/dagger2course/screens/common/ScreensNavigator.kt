package com.techyourchance.dagger2course.screens.common

import android.app.Activity
import android.content.Context
import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity

class ScreensNavigator(private val actvity: Activity) {

    fun navigateBack(){
        actvity.onBackPressed()
    }

    fun toQuestionDetails(questionId: String){
            QuestionDetailsActivity.start(actvity, questionId)
    }
}
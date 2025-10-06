package com.example.daggertwo.screens.common

import android.app.Activity
import android.content.Context
import com.example.daggertwo.screens.questiondetails.QuestionDetailsActivity

class ScreensNavigator(private val actvity: Activity) {

    fun navigateBack(){
        actvity.onBackPressed()
    }

    fun toQuestionDetails(questionId: String){
            QuestionDetailsActivity.start(actvity, questionId)
    }
}
package com.example.daggertwo.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.example.daggertwo.common.dependencyinjection.activity.ActivityScope
import com.example.daggertwo.screens.questiondetails.QuestionDetailsActivity
import javax.inject.Inject

class ScreensNavigatorImpl @Inject constructor (private val actvity: AppCompatActivity) : ScreensNavigator {

    override fun navigateBack(){
        actvity.onBackPressed()
    }
    override fun toQuestionDetails(questionId: String){
            QuestionDetailsActivity.start(actvity, questionId)
    }
}
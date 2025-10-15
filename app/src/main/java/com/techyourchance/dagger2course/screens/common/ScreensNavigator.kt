package com.example.daggertwo.screens.common

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.daggertwo.common.dependencyinjection.activity.ActivityScope
import com.example.daggertwo.screens.questiondetails.QuestionDetailsActivity
import javax.inject.Inject

class ScreensNavigator(private val actvity: AppCompatActivity) {

    fun navigateBack(){
        actvity.onBackPressed()
    }

    fun toQuestionDetails(questionId: String){
            QuestionDetailsActivity.start(actvity, questionId)
    }
}
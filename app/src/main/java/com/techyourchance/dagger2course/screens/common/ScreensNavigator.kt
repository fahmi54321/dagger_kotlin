package com.example.daggertwo.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.example.daggertwo.screens.questiondetails.QuestionDetailsActivity

interface ScreensNavigator {
    fun navigateBack()
    fun toQuestionDetails(questionId: String)
    fun toViewModel()
}
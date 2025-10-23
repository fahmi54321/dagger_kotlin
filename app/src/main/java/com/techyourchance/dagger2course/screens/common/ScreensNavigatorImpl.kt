package com.example.daggertwo.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.example.daggertwo.screens.questiondetails.QuestionDetailsActivity
import com.techyourchance.dagger2course.screens.viewmodel.ViewModelActivity
import javax.inject.Inject

class ScreensNavigatorImpl @Inject constructor (private val actvity: AppCompatActivity) : ScreensNavigator {

    override fun navigateBack(){
        actvity.onBackPressed()
    }
    override fun toQuestionDetails(questionId: String){
            QuestionDetailsActivity.start(actvity, questionId)
    }

    override fun toViewModel() {
        ViewModelActivity.start(actvity)
    }
}
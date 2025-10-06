package com.example.daggertwo.screens.common.viewsmvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.daggertwo.screens.questiondetails.QuestionDetailsListMvc
import com.example.daggertwo.screens.questionslist.QuestionsListViewMvc

class ViewMvcFactory(private val layoutInflater: LayoutInflater) {
    fun newQuestionsListViewMvc(parent: ViewGroup?): QuestionsListViewMvc{
        return QuestionsListViewMvc(layoutInflater, parent)
    }

    fun newQuestionDetailsListMvc(parent: ViewGroup?): QuestionDetailsListMvc{
        return QuestionDetailsListMvc(layoutInflater, parent)
    }
}
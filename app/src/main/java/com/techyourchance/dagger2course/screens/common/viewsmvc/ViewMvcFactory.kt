package com.example.daggertwo.screens.common.viewsmvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.daggertwo.screens.questiondetails.QuestionDetailsListMvc
import com.example.daggertwo.screens.questionslist.QuestionsListViewMvc
import com.techyourchance.dagger2course.screens.common.imageloader.ImageLoader
import com.techyourchance.dagger2course.screens.questionslistviewmodel.QuestionsListView
import javax.inject.Inject

class ViewMvcFactory @Inject constructor(
    private val layoutInflater: LayoutInflater,
    private val imageLoaderProvider: ImageLoader
) {
    fun newQuestionsListViewMvc(parent: ViewGroup?): QuestionsListViewMvc{
        return QuestionsListViewMvc(layoutInflater, parent)
    }

    fun newQuestionDetailsListMvc(parent: ViewGroup?): QuestionDetailsListMvc{
        return QuestionDetailsListMvc(layoutInflater, parent, imageLoaderProvider)
    }

    fun newQuestionsListView(parent: ViewGroup?): QuestionsListView {
        return QuestionsListView(layoutInflater, parent)
    }
}
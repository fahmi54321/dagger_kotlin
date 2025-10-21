package com.techyourchance.dagger2course.screens.questionslistviewmodel

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.daggertwo.R
import com.example.daggertwo.questions.FetchQuestionUseCase
import com.example.daggertwo.questions.Question
import com.example.daggertwo.screens.common.ScreensNavigator
import com.example.daggertwo.screens.common.activities.BaseActivity
import com.example.daggertwo.screens.common.dialogs.DialogsNavigator
import com.example.daggertwo.screens.common.viewsmvc.ViewMvcFactory
import com.techyourchance.dagger2course.screens.viewmodel.ViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import javax.inject.Inject

class QuestionsListViewModelActivity : BaseActivity(),QuestionsListView.Listener {

    private lateinit var viewMvc: QuestionsListView
    private lateinit var viewModelQuestionsList: QuestionsListViewModel

    private var isDataLoaded = false

    @Inject
    lateinit var fetchQuestionUseCase: FetchQuestionUseCase
    @Inject
    lateinit var dialogsNavigator: DialogsNavigator
    @Inject
    lateinit var screensNavigator: ScreensNavigator
    @Inject
    lateinit var viewMvcFactory: ViewMvcFactory
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        viewMvc = viewMvcFactory.newQuestionsListView(null)
        setContentView(viewMvc.rootView)

        initViewModel()
        observer()
    }

    private fun initViewModel(){
        viewModelQuestionsList = ViewModelProvider(this,viewModelFactory).get(QuestionsListViewModel::class.java)
    }

    private fun observer(){
        viewModelQuestionsList.question.observe(this) { questions ->
            viewMvc.bindQuestions(questions)
        }
        viewModelQuestionsList.showProgressIndication.observe(this){data->
            if(data){
                viewMvc.showProgressIndication()
            }
        }
        viewModelQuestionsList.hideProgressIndication.observe(this){data->
            if(data){
                viewMvc.hideProgressIndication()
            }
        }
        viewModelQuestionsList.isDataLoaded.observe(this){data->
            if(data){
                isDataLoaded = true
            }
        }
        viewModelQuestionsList.isFetchFailed.observe(this){data->
            if(data){
                onFetchFailed()
            }
        }
    }

    private fun fetchQuestions() {
        viewModelQuestionsList.fetchQuestion()
    }

    private fun onFetchFailed() {
        dialogsNavigator.showServerErrorDialog()
    }

    override fun onStart() {
        super.onStart()
        viewMvc.registerListener(this)
        if (!isDataLoaded) {
            fetchQuestions()
        }
    }

    override fun onStop() {
        super.onStop()
        viewMvc.unregisterListener(this)
        viewModelQuestionsList.cancelChildren()
    }

    override fun onRefreshClicked() {
        fetchQuestions()
    }

    override fun onQuestionClicked(clickedQuestion: Question) {
        screensNavigator.toQuestionDetails(clickedQuestion.id)
    }

    override fun toViewModel() {
        screensNavigator.toViewModel()
    }
}
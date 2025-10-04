package com.techyourchance.dagger2course.screens.questiondetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.fragments.BaseFragment
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMvcFactory
import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity.Companion.EXTRA_QUESTION_ID
import kotlinx.coroutines.*
import javax.inject.Inject

class QuestionDetailsFragment : BaseFragment(), QuestionDetailsListMvc.Listener {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)


    private lateinit var questionId: String

    private lateinit var viewMvc: QuestionDetailsListMvc

    @Inject lateinit var fetchQuestionDetailsUseCase: FetchQuestionDetailsUseCase

    @Inject lateinit var dialogsNavigator: DialogsNavigator

    @Inject lateinit var screensNavigator: ScreensNavigator

    @Inject lateinit var viewMvcFactory: ViewMvcFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // retrieve question ID passed from outside
        questionId = requireActivity().intent.extras!!.getString(EXTRA_QUESTION_ID)!!

        injector.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewMvc = viewMvcFactory.newQuestionDetailsListMvc(container)
        return viewMvc.rootView
    }

    override fun onStart() {
        super.onStart()
        viewMvc.registerListener(this)
        fetchQuestionDetails()
    }


    override fun onStop() {
        super.onStop()
        viewMvc.unregisterListener(this)
        coroutineScope.coroutineContext.cancelChildren()
    }

    private fun fetchQuestionDetails() {
        coroutineScope.launch {
            viewMvc.showProgressIndication()
            try {
                val result = fetchQuestionDetailsUseCase.fetchQuestionDetails(questionId)
                when(result){
                    is FetchQuestionDetailsUseCase.Result.Success ->{
                        viewMvc.bindQuesionBody(result.body)
                    }
                    is FetchQuestionDetailsUseCase.Result.Failure -> onFetchFailed()
                }
            } finally {
                viewMvc.hideProgressIndication()
            }

        }
    }

    private fun onFetchFailed() {
        dialogsNavigator.showServerErrorDialog()
    }


    override fun onBack() {
        screensNavigator.navigateBack()
    }
}
package com.techyourchance.dagger2course.screens.questionslistviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.example.daggertwo.questions.FetchQuestionUseCase
import com.example.daggertwo.questions.Question
import com.techyourchance.dagger2course.screens.viewmodel.SavedStateViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import javax.inject.Inject

class QuestionsListViewModel @Inject constructor(
    val fetchQuestionUseCase: FetchQuestionUseCase
) : SavedStateViewModel() {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private lateinit var _question: MutableLiveData<List<Question>>
    private val _showProgressIndication: MutableLiveData<Boolean> = MutableLiveData(false)
    private val _hideProgressIndication: MutableLiveData<Boolean> = MutableLiveData(false)
    private val _isDataLoaded: MutableLiveData<Boolean> = MutableLiveData(false)
    private val _isFetchFailed: MutableLiveData<Boolean> = MutableLiveData(false)

    val question get() = _question
    val showProgressIndication get() = _showProgressIndication
    val hideProgressIndication get() = _hideProgressIndication
    val isDataLoaded get() = _isDataLoaded
    val isFetchFailed get() = _isFetchFailed



    override fun init(savedStateHandle: SavedStateHandle) {
        _question = savedStateHandle.getLiveData("questions", emptyList())
    }

    fun fetchQuestion(){
        coroutineScope.launch {
            _showProgressIndication.value = true
            try {
                val result = fetchQuestionUseCase.fetchLatestQuestions()
                when (result) {
                    is FetchQuestionUseCase.Result.Success -> {
                        _question.value = result.questions
                        _isDataLoaded.value = true
                    }

                    is FetchQuestionUseCase.Result.Failure -> _isFetchFailed.value = true
                    else -> {}
                }
            } finally {
                _hideProgressIndication.value = true
            }

        }
    }

    fun cancelChildren(){
        coroutineScope.coroutineContext.cancelChildren()
    }
}
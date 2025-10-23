package com.techyourchance.dagger2course.screens.questionslistviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.daggertwo.questions.FetchQuestionUseCase
import com.example.daggertwo.questions.Question
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsListViewModel @Inject constructor(
    private val fetchQuestionUseCase: FetchQuestionUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private var _question: MutableLiveData<List<Question>> = savedStateHandle.getLiveData("questions", emptyList())
    private val _showProgressIndication: MutableLiveData<Boolean> = MutableLiveData(false)
    private val _hideProgressIndication: MutableLiveData<Boolean> = MutableLiveData(false)
    private val _isDataLoaded: MutableLiveData<Boolean> = MutableLiveData(false)
    private val _isFetchFailed: MutableLiveData<Boolean> = MutableLiveData(false)

    val question get() = _question
    val showProgressIndication get() = _showProgressIndication
    val hideProgressIndication get() = _hideProgressIndication
    val isDataLoaded get() = _isDataLoaded
    val isFetchFailed get() = _isFetchFailed

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
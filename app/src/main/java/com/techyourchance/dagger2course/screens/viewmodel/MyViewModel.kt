package com.techyourchance.dagger2course.screens.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.daggertwo.questions.FetchQuestionDetailsUseCase
import com.example.daggertwo.questions.FetchQuestionUseCase
import com.example.daggertwo.questions.Question
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider
import kotlin.time.Duration

class MyViewModel @Inject constructor(
    val fetchQuestionUseCase: FetchQuestionUseCase,
    val fetchQuestionDetailsUseCase: FetchQuestionDetailsUseCase,
): SavedStateViewModel() {
    private lateinit var _questions : MutableLiveData<List<Question>>
    val question: LiveData<List<Question>> get() = _questions

    override fun init(savedStateHandle: SavedStateHandle) {
        _questions = savedStateHandle.getLiveData("questions", emptyList())

        viewModelScope.launch {
            delay(5000)
            val result = fetchQuestionUseCase.fetchLatestQuestions()
            if(result is FetchQuestionUseCase.Result.Success){
                _questions.value = result.questions
            }else{
                throw RuntimeException("fetch failed")
            }
        }
    }
}
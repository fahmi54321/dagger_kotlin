package com.techyourchance.dagger2course.screens.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.daggertwo.questions.FetchQuestionUseCase
import com.example.daggertwo.questions.Question
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

class MyViewModel @Inject constructor(val fetchQuestionUseCase: FetchQuestionUseCase): ViewModel() {
    private val _questions = MutableLiveData<List<Question>>()
    val question: LiveData<List<Question>> = _questions

    init {
        viewModelScope.launch {
            val result = fetchQuestionUseCase.fetchLatestQuestions()
            if(result is FetchQuestionUseCase.Result.Success){
                _questions.value = result.questions
            }else{
                throw RuntimeException("fetch failed")
            }
        }
    }

    class MyViewModelFactory @Inject constructor (val fetchQuestionUseCaseProvider: Provider<FetchQuestionUseCase>): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MyViewModel(fetchQuestionUseCaseProvider.get()) as T
        }
    }
}
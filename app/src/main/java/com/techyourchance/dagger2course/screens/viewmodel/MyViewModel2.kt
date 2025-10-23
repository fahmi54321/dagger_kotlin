package com.techyourchance.dagger2course.screens.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.daggertwo.questions.FetchQuestionDetailsUseCase
import com.example.daggertwo.questions.FetchQuestionUseCase
import com.example.daggertwo.questions.Question
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class MyViewModel2 @Inject constructor(
    val fetchQuestionUseCase: FetchQuestionUseCase,
): ViewModel() {
    private val _questions = MutableLiveData<List<Question>>()
    val question: LiveData<List<Question>> = _questions
}
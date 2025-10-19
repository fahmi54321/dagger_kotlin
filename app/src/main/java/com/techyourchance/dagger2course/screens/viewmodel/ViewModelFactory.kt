package com.techyourchance.dagger2course.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.daggertwo.questions.FetchQuestionDetailsUseCase
import com.example.daggertwo.questions.FetchQuestionUseCase
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor (
    val fetchQuestionUseCaseProvider: Provider<FetchQuestionUseCase>,
    val fetchQuestionDetailsUseCaseProvider: Provider<FetchQuestionDetailsUseCase>,
): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        val savedStateHandle = extras.createSavedStateHandle()
        return when(modelClass){
            MyViewModel::class.java-> MyViewModel(
                fetchQuestionUseCaseProvider.get(),
                fetchQuestionDetailsUseCaseProvider.get(),
                savedStateHandle,
            ) as T
            MyViewModel2::class.java -> MyViewModel2(
                fetchQuestionUseCaseProvider.get()
            ) as T
            else -> throw RuntimeException("unsupported viewmodel type: $modelClass")
        }
    }
}
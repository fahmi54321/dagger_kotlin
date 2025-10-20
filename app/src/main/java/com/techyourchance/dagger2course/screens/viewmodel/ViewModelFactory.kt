package com.techyourchance.dagger2course.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.daggertwo.questions.FetchQuestionDetailsUseCase
import com.example.daggertwo.questions.FetchQuestionUseCase
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

class ViewModelFactory @Inject constructor (
    val providers: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        val savedStateHandle = extras.createSavedStateHandle()
        val provider = providers[modelClass]
        val viewModel = provider?.get() ?: throw RuntimeException("unsupported viewmodel type: $modelClass")
        if (viewModel is SavedStateViewModel) {
            viewModel.init(savedStateHandle)
        }
        return viewModel as T
    }
}
package com.techyourchance.dagger2course.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor (
    val myViewModelProvider: Provider<MyViewModel>,
    val myViewModel2Provider: Provider<MyViewModel2>
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MyViewModel::class.java) -> myViewModelProvider.get() as T
            modelClass.isAssignableFrom(MyViewModel2::class.java) -> myViewModel2Provider.get() as T
            else -> throw IllegalArgumentException("Unsupported ViewModel type: $modelClass")
        }
    }
}
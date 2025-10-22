package com.techyourchance.dagger2course.common.dependencyinjection.presentation

import androidx.lifecycle.ViewModel
import com.techyourchance.dagger2course.screens.questionslistviewmodel.QuestionsListViewModel
import com.techyourchance.dagger2course.screens.viewmodel.MyViewModel
import com.techyourchance.dagger2course.screens.viewmodel.MyViewModel2
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel::class)
    abstract fun myViewModel(myViewModel: MyViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel2::class)
    abstract fun myViewModel2(myViewModel2: MyViewModel2) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(QuestionsListViewModel::class)
    abstract fun questionsListViewModel(questionsListViewModel: QuestionsListViewModel) : ViewModel
}

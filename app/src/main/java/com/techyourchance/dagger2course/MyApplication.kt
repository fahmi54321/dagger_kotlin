package com.techyourchance.dagger2course

import android.app.Application
import com.techyourchance.dagger2course.common.compisition.AppCompisitionRoot
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication: Application() {

    lateinit var appCompositionRoot: AppCompisitionRoot

    override fun onCreate() {
        appCompositionRoot = AppCompisitionRoot()
        super.onCreate()
    }
}
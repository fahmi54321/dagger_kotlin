package com.techyourchance.dagger2course.common.dependencyinjection

import android.app.Activity
import android.app.Application
import androidx.annotation.UiThread
import com.techyourchance.dagger2course.Constants
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@UiThread
class AppCompisitionRoot(val application: Application) {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val stackoverflowApi: StackoverflowApi by lazy {
        retrofit.create(StackoverflowApi::class.java)
    }

    fun screensNavigator(activity: Activity): ScreensNavigator{
        return ScreensNavigator(activity);
    }
}
package com.example.daggertwo.common.dependencyinjection.app

import android.app.Application
import com.example.daggertwo.Constants
import com.example.daggertwo.networking.StackoverflowApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(val application: Application) {

    @Provides
    @AppScope
    fun retrofit():Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @AppScope
    fun stackoverflowApi(retrofit: Retrofit) = retrofit.create(StackoverflowApi::class.java)

    @Provides
    fun application() = application
}
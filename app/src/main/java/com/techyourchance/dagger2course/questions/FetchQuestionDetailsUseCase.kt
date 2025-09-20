package com.techyourchance.dagger2course.questions

import com.techyourchance.dagger2course.Constants
import com.techyourchance.dagger2course.networking.StackoverflowApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.cancellation.CancellationException

class FetchQuestionDetailsUseCase(private val questionId: String, private val retrofit: Retrofit) {

    sealed class Result {
        class Success(val body: String) : Result()
        object Failure : Result()
    }

    private var stackoverflowApi: StackoverflowApi = retrofit.create(StackoverflowApi::class.java)

    suspend fun fetchQuestionDetails() : Result{
        return withContext(Dispatchers.IO){
            try {
                val response = stackoverflowApi.questionDetails(questionId)
                if (response.isSuccessful && response.body() != null) {
                    return@withContext Result.Success(response.body()!!.question.body)
                } else {
                    return@withContext Result.Failure
                }
            } catch (t: Throwable) {
                if (t !is CancellationException) {
                    return@withContext Result.Failure
                }else{
                    throw t
                }
            }
        }

    }


}
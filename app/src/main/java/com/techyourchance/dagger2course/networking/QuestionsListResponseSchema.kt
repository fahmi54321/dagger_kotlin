package com.example.daggertwo.networking

import com.google.gson.annotations.SerializedName
import com.example.daggertwo.questions.Question

class QuestionsListResponseSchema(@SerializedName("items") val questions: List<Question>)
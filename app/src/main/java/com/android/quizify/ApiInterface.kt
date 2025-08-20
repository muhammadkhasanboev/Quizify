package com.android.quizify

import com.android.quizify.DataClass.QuizResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("api.php")
    suspend fun getQuizQuestions(
        @Query("amount") amount: Int,
        @Query("category") category: String?,
        @Query("difficulty") difficulty: String?,
        @Query("type") type: String?
    ): Response<QuizResponse>
}
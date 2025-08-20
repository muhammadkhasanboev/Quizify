package com.android.quizify.DataClass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class QuizResponse(
    val results: List<Question>
): Parcelable


@Parcelize
data class Question(
    val type: String,
    val difficulty: String,
    val category : String,
    val question: String,
    val correct_answer: String
) : Parcelable
package com.example.qwizzr.network

import com.squareup.moshi.Json

data class Question(
    val category: String,
    val type: String,
    val difficulty: String,
    val question: String,
    @Json(name = "correct_answer") val correctAnswer: String,
    @Json(name = "incorrect_answers") val incorrectAnswers: List<String>
)

data class ApiResponse(
    @Json(name = "response_code") val responseCode: Int,
    val results: List<Question>
)
package com.example.qwizzr.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://opentdb.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface OpenTriviaApiService {
    @GET("api.php")
    suspend fun getQuestions(@Query("amount") amount: Int, @Query("type") type: String): ApiResponse
}

object OpenTriviaApi {
    val retrofitService: OpenTriviaApiService by lazy { retrofit.create(OpenTriviaApiService::class.java) }
}
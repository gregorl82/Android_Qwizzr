package com.example.qwizzr

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qwizzr.network.ApiResponse
import com.example.qwizzr.network.OpenTriviaApi
import com.example.qwizzr.network.Question
import kotlinx.coroutines.launch
import timber.log.Timber

class MainActivityViewModel : ViewModel() {

    private lateinit var response: ApiResponse
    private var questions = listOf<Question>()

    init {
        getQuestions()
    }

    private fun getQuestions() {
        viewModelScope.launch {
            response = OpenTriviaApi.retrofitService.getQuestions(10, "multiple")

            questions = response.results
            Timber.i(questions.toString())
            Timber.i(questions.size.toString())
        }
    }

}
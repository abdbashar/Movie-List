package com.example.movielist.data.services

import com.example.movielist.data.model.MovieResponse
import com.example.movielist.data.request.ApiClient
import com.example.movielist.data.request.State
import com.google.gson.Gson
import okhttp3.OkHttpClient

class MovieService() {
    private val client = OkHttpClient()
    fun getMostPopularMovies(): State<MovieResponse> {
        val response = client.newCall(ApiClient.apiRequest()).execute()

        return if(response.isSuccessful)
            Gson().fromJson(
                response.body?.string(),MovieResponse::class.java
            ).run {
                State.Success(this)
            }
        else State.Failure(response.message)
    }
}
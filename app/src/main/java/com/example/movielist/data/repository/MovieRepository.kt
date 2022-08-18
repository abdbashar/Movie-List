package com.example.movielist.data.repository

import com.example.movielist.data.model.MovieResponse
import com.example.movielist.data.request.State
import com.example.movielist.data.services.MovieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher

class MovieRepository() {
    suspend fun getPopularMovies(): Flow<State<MovieResponse>> = flow{
            emit(State.Loading)
            emit(MovieService().getMostPopularMovies())
    }.flowOn(Dispatchers.IO)
}
package com.example.movielist.data.request

sealed class State<out T> {
    object Loading : State<Nothing>()
    class Success<T>(val data: T) : State<T>()
    class Failure<T>(val errorMessage: String) : State<T>()
}
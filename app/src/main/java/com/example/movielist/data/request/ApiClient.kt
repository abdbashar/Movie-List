package com.example.movielist.data.request

import com.example.movielist.util.Constant.API_KEY
import com.example.movielist.util.Constant.BASE_URL
import okhttp3.Request

object ApiClient {
     fun apiRequest(): Request{
         val url=  "${BASE_URL}${API_KEY}"
         return Request.Builder()
            .url(url)
            .get()
            .build()
    }
}
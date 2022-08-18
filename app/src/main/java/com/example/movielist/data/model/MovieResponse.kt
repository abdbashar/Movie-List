package com.example.movielist.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(
    @SerializedName("results")
    val movies : List<MovieData>
) : Parcelable {
    constructor() : this(mutableListOf())
}

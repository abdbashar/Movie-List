package com.example.movielist.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieData(
    @SerializedName("id")
    val id : String ?,

    @SerializedName("title")
    val title : String ?,

    @SerializedName("release_date")
    val year : String ?,

    @SerializedName("poster_path")
    val posterPath : String ?,

    @SerializedName("vote_average")
    val imDbRating: String ?,

    @SerializedName("overview")
    val description: String ?



): Parcelable{
    constructor(): this("id","title","release_date",
        "poster_path","vote_average","overview")
}

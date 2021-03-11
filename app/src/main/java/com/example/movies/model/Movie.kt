package com.example.movies.model

import androidx.annotation.StringRes
import com.google.gson.annotations.SerializedName

data class Movie(

    @SerializedName("poster_path")
    val posterPath: String,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("backdrop_path")
    val backdropPath: String?,

    @SerializedName("vote_average")
    val voteAverage: Float
)
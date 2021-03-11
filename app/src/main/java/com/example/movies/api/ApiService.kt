package com.example.movies.api

import com.example.movies.constants.POPULAR_MOVIE
import com.example.movies.constants.TOP_RATED_MOVIE
import com.example.movies.constants.UPCOMING_MOVIE
import com.example.movies.model.DBMoviesResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET(POPULAR_MOVIE+"?api_key=67a791c794000b9c3adf87e7a3386597")
    fun getPopularMovies(@Header("Authorization") token: String): Single<DBMoviesResponse>

    @GET(TOP_RATED_MOVIE)
    fun getTopRatedMovies(@Header("Authorization") token: String): Single<DBMoviesResponse>

    @GET(UPCOMING_MOVIE)
    fun getUpcomingMovies(@Header("Authorization") token: String): Single<DBMoviesResponse>

}
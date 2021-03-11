package com.example.movies.controllers

import com.example.movies.model.Movie
import io.reactivex.rxjava3.core.Single

interface MoviesController {
    fun getPopularMovies(token: String): Single<List<Movie>>
    fun getTopRatedMovies(token: String): Single<List<Movie>>
    fun getUpcomingMovies(token: String): Single<List<Movie>>
}
package com.example.movies.controllers

import com.example.movies.api.ApiClient
import com.example.movies.api.ApiService
import com.example.movies.model.Movie
import io.reactivex.rxjava3.core.Single

class MoviesControllerImpl : MoviesController {

    private val service: ApiService = ApiClient.service

    override fun getPopularMovies(token: String): Single<List<Movie>> {
        return service.getPopularMovies(token).map {
            it.results
        }
    }

    override fun getTopRatedMovies(token: String): Single<List<Movie>> {
        return  service.getTopRatedMovies(token).map {
            it.results
        }
    }

    override fun getUpcomingMovies(token: String): Single<List<Movie>> {
        return  service.getUpcomingMovies(token).map {
            it.results
        }
    }
}
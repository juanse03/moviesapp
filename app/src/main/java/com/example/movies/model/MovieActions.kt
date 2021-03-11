package com.example.movies.model

sealed class MovieActions {
    class ShowMovies(val movieList: List<Movie>): MovieActions()
}
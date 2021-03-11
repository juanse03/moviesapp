package com.example.movies.activities

import android.view.View
import com.example.movies.R
import com.example.movies.activities.popular.PopularMoviesViewModel
import com.example.movies.constants.IMAGE_BASE_URL
import com.example.movies.databinding.MovieItemBinding
import com.example.movies.model.Movie
import com.squareup.picasso.Picasso
import com.xwray.groupie.viewbinding.BindableItem
import com.xwray.groupie.viewbinding.GroupieViewHolder

class MovieItem(val movie: Movie) : BindableItem<MovieItemBinding>() {

    override fun bind(viewBinding: MovieItemBinding, position: Int) {
        Picasso.get().load(IMAGE_BASE_URL + movie.posterPath).into(viewBinding.moviePoster)
        viewBinding.movieTitle.text = movie.title
        viewBinding.movieReleaseDate.text = movie.releaseDate
    }

    override fun getLayout(): Int {
        return R.layout.movie_item
    }

    override fun initializeViewBinding(view: View): MovieItemBinding {
        return MovieItemBinding.bind(view)
    }
}
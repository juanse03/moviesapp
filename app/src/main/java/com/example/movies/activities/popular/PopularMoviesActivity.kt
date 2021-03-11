package com.example.movies.activities.popular

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.R
import com.example.movies.activities.MovieItem
import com.example.movies.databinding.ActivityPopularMoviesBinding
import com.example.movies.model.Movie
import com.example.movies.model.MovieActions
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class PopularMoviesActivity : AppCompatActivity() {


    private val groupAdapter = GroupAdapter<GroupieViewHolder>()
    private lateinit var binding: ActivityPopularMoviesBinding
    private var viewModel = PopularMoviesViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPopularMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecycler()
        setObserver()
        viewModel.getPopularMovies(getString(R.string.auth_token_api))
    }

    private fun setObserver() {
        viewModel.data.observe(this, ::handleData)
    }

    private fun handleData(action: MovieActions) = when (action) {
        is MovieActions.ShowMovies -> showPopularMoviesList(movieList = action.movieList)
    }

    private fun showPopularMoviesList(movieList: List<Movie>) {
        movieList.map {
            groupAdapter.add(MovieItem(it))
        }
    }

    private fun setRecycler() {
        binding.popularMoviesContainer.adapter = groupAdapter
        binding.popularMoviesContainer.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}
package com.example.movies.activities.popular

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.controllers.MoviesController
import com.example.movies.controllers.MoviesControllerImpl
import com.example.movies.model.MovieActions
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class PopularMoviesViewModel: ViewModel() {

    private val controller: MoviesController = MoviesControllerImpl()
    private val _data = MutableLiveData<MovieActions>()

    val data: LiveData<MovieActions> get()=_data

    fun getPopularMovies(token: String){
        controller.getPopularMovies(token)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                _data.value = MovieActions.ShowMovies(it)
                },
                {
                Log.e("Popular Movies", it.message, it)
                }
            )
    }


}
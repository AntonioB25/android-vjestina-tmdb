package com.e.tmdb.viewModel

import androidx.lifecycle.ViewModel
import com.e.tmdb.models.movie.Movie
import com.e.tmdb.models.movieDetails.MovieDetails
import com.e.tmdb.respository.MovieRepository

class MovieDetailsViewModel(
    movieRepository: MovieRepository
): ViewModel() {

    fun getMovieDetails(): MovieDetails{
        return MovieDetails(2)
    }

}
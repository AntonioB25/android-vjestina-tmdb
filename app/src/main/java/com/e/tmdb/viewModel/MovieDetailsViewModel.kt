package com.e.tmdb.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.tmdb.models.movie.Movie
import com.e.tmdb.models.movieCredits.MovieCredits
import com.e.tmdb.models.movieDetails.MovieDetails
import com.e.tmdb.respository.MovieDetailsRepository
import com.e.tmdb.respository.MovieRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
   private val movieDetailsRepository: MovieDetailsRepository
): ViewModel() {

    // TODO: remove nullable
    fun getMovieDetails(movieId: Int): MovieDetails?{
        var details: MovieDetails? = null
        viewModelScope.launch {
            movieDetailsRepository.getMovieDetails(movieId).collect {
                details = it
            }
        }
        return details
    }

    // TODO: remove nullable
    fun getMovieCredits(movieId: Int): MovieCredits?{
        var credits: MovieCredits? = null
        viewModelScope.launch {
             movieDetailsRepository.getMovieCredits(movieId).collect {
                credits = it
            }
        }
        return credits
    }

}
package com.e.tmdb.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.tmdb.models.movie.Movie
import com.e.tmdb.respository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class HomeViewModel(
    private val movieRepository: MovieRepository
) : ViewModel() {


    fun getPopularMovies(): List<Movie> {
        var movies: List<Movie> = emptyList()
        viewModelScope.launch {
            movies = movieRepository.getPopularMovies().flattenToList()
        }
        return movies
    }

    fun getTopRatedMovies(): List<Movie>{
        var movies: List<Movie> = emptyList()
        viewModelScope.launch {
            movies = movieRepository.getTopRatedMovies().flattenToList()
        }
        return movies
    }

    fun getNowPlayingMovies(): List<Movie> {
        var movies: List<Movie> = emptyList()
        viewModelScope.launch {
            movies = movieRepository.getNowPlayingMovies().flattenToList()
        }
        return movies
    }

    fun getUpcomingMovies(): List<Movie> {
        var movies: List<Movie> = emptyList()
        viewModelScope.launch {
            movies = movieRepository.getUpcomingMovies().flattenToList()
        }
        return movies
    }


    private suspend fun <T> Flow<List<T>>.flattenToList() =
        flatMapConcat { it.asFlow() }.toList()

}
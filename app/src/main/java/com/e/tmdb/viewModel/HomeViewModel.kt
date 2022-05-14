package com.e.tmdb.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.tmdb.models.movie.Movie
import com.e.tmdb.respository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class HomeViewModel(
    private val movieRepository: MovieRepository
) : ViewModel() {


    fun getPopularMovies(): MutableStateFlow<List<Movie>> {
        val movies = MutableStateFlow<List<Movie>>(emptyList())
        viewModelScope.launch {
            movieRepository.getPopularMovies().collect { movies.emit(it) }
        }
        return movies
    }

    fun getTopRatedMovies(): MutableStateFlow<List<Movie>> {
        val movies = MutableStateFlow<List<Movie>>(emptyList())
        viewModelScope.launch {
            movieRepository.getTopRatedMovies().collect { movies.emit(it) }
        }
        return movies
    }

    fun getNowPlayingMovies(): MutableStateFlow<List<Movie>> {
        val movies = MutableStateFlow<List<Movie>>(emptyList())
        viewModelScope.launch {
            movieRepository.getNowPlayingMovies().collect { movies.emit(it) }
        }
        return movies
    }

    fun getUpcomingMovies(): MutableStateFlow<List<Movie>> {
        val movies = MutableStateFlow<List<Movie>>(emptyList())
        viewModelScope.launch {
            movieRepository.getUpcomingMovies().collect { movies.emit(it) }
        }
        return movies
    }

    // TODO: fix
    // This does not refresh favourites screen when I "unfavourite" movie. I need to leave screen and come back...


    private val favourites = MutableStateFlow<List<Movie>>(emptyList())

    fun addToFavourites(movie: Movie) {
        viewModelScope.launch {
            movieRepository.addToFavourites(movie)
            val list = movieRepository.getFavouriteMovies().collect{ }
        }
    }

    fun removeFromFavourites(movie: Movie) {
        val list = getFavouriteMovies().value.toMutableList()
        list.remove(movie)
        getFavouriteMovies().value = list
        viewModelScope.launch {
            movieRepository.removeFromFavourites(movie)
        }
    }

    fun getFavouriteMovies(): MutableStateFlow<List<Movie>> {
        viewModelScope.launch {
            movieRepository.getFavouriteMovies().collect { favourites.emit(it) }
        }
        return favourites
    }
}
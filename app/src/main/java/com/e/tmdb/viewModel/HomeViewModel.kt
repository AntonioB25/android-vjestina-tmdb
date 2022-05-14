package com.e.tmdb.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.tmdb.models.movie.Movie
import com.e.tmdb.respository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class HomeViewModel(
    private val movieRepository: MovieRepository
) : ViewModel() {
    private val popular = MutableStateFlow<List<Movie>>(emptyList())
    private val upcoming = MutableStateFlow<List<Movie>>(emptyList())
    private val topRated = MutableStateFlow<List<Movie>>(emptyList())
    private val nowPlaying = MutableStateFlow<List<Movie>>(emptyList())

    fun getPopularMovies(): MutableStateFlow<List<Movie>> {
        viewModelScope.launch {
            movieRepository.getPopularMovies().collect { popular.emit(it) }
        }
        return popular
    }

    fun getTopRatedMovies(): MutableStateFlow<List<Movie>> {
        viewModelScope.launch {
            movieRepository.getTopRatedMovies().collect { topRated.emit(it) }
        }
        return topRated
    }

    fun getNowPlayingMovies(): MutableStateFlow<List<Movie>> {
        viewModelScope.launch {
            movieRepository.getNowPlayingMovies().collect { nowPlaying.emit(it) }
        }
        return nowPlaying
    }

    fun getUpcomingMovies(): MutableStateFlow<List<Movie>> {
        viewModelScope.launch {
            movieRepository.getUpcomingMovies().collect { upcoming.emit(it) }
        }
        return upcoming
    }

    // TODO: fix
    // This does not refresh favourites screen when I "unfavourite" movie. I need to leave screen and come back...

    fun addToFavourites(movie: Movie) {
        viewModelScope.launch {
            movieRepository.addToFavourites(movie)
        }
    }

    fun removeFromFavourites(movie: Movie) {
        viewModelScope.launch {
            movieRepository.removeFromFavourites(movie)
        }
    }

    fun getFavouriteMovies(): MutableStateFlow<List<Movie>> {
        val favourites = MutableStateFlow<List<Movie>>(emptyList())
        viewModelScope.launch {
            movieRepository.getFavouriteMovies().collect { favourites.emit(it) }
        }
        return favourites
    }
}
package com.e.tmdb.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.tmdb.R
import com.e.tmdb.models.movieCredits.CastMember
import com.e.tmdb.models.movieCredits.CrewMember
import com.e.tmdb.models.movieCredits.MovieCredits
import com.e.tmdb.models.movieDetails.MovieDetails
import com.e.tmdb.models.movieDetails.MovieGenre
import com.e.tmdb.models.movieDetails.ProductionCountry
import com.e.tmdb.respository.MovieDetailsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val movieDetailsRepository: MovieDetailsRepository
) : ViewModel() {

    // TODO: fix
    // I was trying to return MutableStateFlow, but I don't know what to provide as default value.
    // Cannot put null
    fun getMovieDetails(movieId: Int): MutableStateFlow<MovieDetails> {
        val details = MutableStateFlow<MovieDetails>(getBlankMovieDetails())
        viewModelScope.launch {
            movieDetailsRepository.getMovieDetails(movieId).collect {
                details.emit(it)
            }
        }
        return details
    }

    // TODO: fix
    // I was trying to return MutableStateFlow, but I don't know what to provide as default value.
    // Cannot put null
    fun getMovieCredits(movieId: Int): MutableStateFlow<MovieCredits> {
        val credits = MutableStateFlow<MovieCredits>(getBlankCredits())
        viewModelScope.launch {
            movieDetailsRepository.getMovieCredits(movieId).collect {
                credits.emit(it)
            }
        }
        return credits
    }


    private fun getBlankMovieDetails(): MovieDetails {
        return MovieDetails(
            0,
            "No Title",
            "picture",
            "psoter",
            listOf(MovieGenre(1, "genre")),
            "Original lang",
            "Title",
            "OV",
            "date",
            0,
            listOf(ProductionCountry("test", "name")),
        )
    }


    private fun getBlankCredits(): MovieCredits {
        return MovieCredits(
            3,
            listOf(
                CastMember(
                    2,
                    "Actor",
                    "character",
                    R.drawable.rdj.toString(),
                    2,
                    3,
                    4,
                    "depart",
                    true,
                    0,
                )
            ),
            listOf(
                CrewMember(
                    1,
                    "name",
                    2,
                    "job",
                    "depart",
                    "direct",
                    "nestonesto.jpg",
                )
            )
        )
    }
}
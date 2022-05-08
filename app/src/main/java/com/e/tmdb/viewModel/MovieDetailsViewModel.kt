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
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val movieDetailsRepository: MovieDetailsRepository
) : ViewModel() {

    //This will be removed
    val details = MovieDetails(
        2,
        "Iron Man",
        "path",
        R.drawable.ironman.toString(),
        listOf(MovieGenre(2, "action"), MovieGenre(3, "Science fiction")),
        "English",
        "Iron man",
        "After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil.",
        "05/02/2008",
        128,
        listOf(ProductionCountry("US", "USA"))
    )

    val movieCredits = MovieCredits(
        3,
        listOf(
            CastMember(
                2,
                "Robert Downey Jr.",
                "Tony Stark",
                R.drawable.rdj.toString(),
                2,
                3,
                4,
                "Acting",
                true,
                0,
            )
        ),
        listOf(
            CrewMember(
                1,
                "Don Heck",
                2,
                "Director",
                "Direction",
                "Direction",
                "nestonesto.jpg",
            )
        )
    )


    // TODO: fix
    fun getMovieDetails(movieId: Int): MovieDetails {
        var details: MovieDetails = details
        viewModelScope.launch {
            movieDetailsRepository.getMovieDetails(movieId).collect {
                details = it
            }
        }
        return details
    }

    // TODO: fix
    fun getMovieCredits(movieId: Int): MovieCredits {
        var credits: MovieCredits = movieCredits
        viewModelScope.launch {
            movieDetailsRepository.getMovieCredits(movieId).collect {
                credits = it
            }
        }
        return credits
    }
}
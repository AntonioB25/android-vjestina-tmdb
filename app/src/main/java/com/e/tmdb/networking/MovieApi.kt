package com.e.tmdb.networking

import com.e.tmdb.R
import com.e.tmdb.models.*
import com.e.tmdb.models.movie.Movie
import com.e.tmdb.models.movie.MovieResponse
import com.e.tmdb.models.movieCredits.MovieCreditsResponse
import com.e.tmdb.models.movieDetails.MovieDetailsResponse

interface MovieApi {
    suspend fun getPopularMovies(): MovieResponse
    suspend fun getNowPlayingMovies(): MovieResponse
    suspend fun getUpcomingMovies(): MovieResponse
    suspend fun getTopRatedMovies(): MovieResponse
    suspend fun getMovieDetails(movieId: Int): MovieDetailsResponse
    suspend fun getMovieCredits(movieId: Int): MovieCreditsResponse
    suspend fun getSearchMovie(query: String): MovieSearchResponse
}

internal class MovieApiImpl : MovieApi {
    override suspend fun getPopularMovies(): MovieResponse = MovieResponse(
        //TODO: Change to server calls
        movies = listOf(
            Movie(1, "Ironman", R.drawable.ironman),
            Movie(2, "Ironman", R.drawable.ironman),
            Movie(3, "Ironman", R.drawable.ironman),
            Movie(4, "Ironman", R.drawable.ironman),
            Movie(5, "Ironman", R.drawable.ironman),
            Movie(6, "Ironman", R.drawable.ironman)
        )
    )

    override suspend fun getNowPlayingMovies(): MovieResponse = MovieResponse(
        //TODO: Change to server calls
        movies = listOf(
            Movie(1, "Godzzila", R.drawable.godzzila),
            Movie(2, "Godzzila", R.drawable.godzzila),
            Movie(3, "Godzzila", R.drawable.godzzila),
            Movie(4, "Godzzila", R.drawable.godzzila),
            Movie(5, "Godzzila", R.drawable.godzzila),
            Movie(6, "Godzzila", R.drawable.godzzila),
        )
    )

    override suspend fun getUpcomingMovies(): MovieResponse = MovieResponse(
        //TODO: Change to server calls
        movies = listOf(
            Movie(1, "Puppy Love", R.drawable.puppy_love),
            Movie(2, "Puppy Love", R.drawable.puppy_love),
            Movie(3, "Puppy Love", R.drawable.puppy_love),
            Movie(4, "Puppy Love", R.drawable.puppy_love),
            Movie(5, "Puppy Love", R.drawable.puppy_love),
            Movie(6, "Puppy Love", R.drawable.puppy_love)
        )
    )

    override suspend fun getTopRatedMovies(): MovieResponse = MovieResponse(
        //TODO: Change to server calls
        movies = listOf(
            Movie(1, "Puppy Love", R.drawable.puppy_love),
            Movie(2, "Godzzila", R.drawable.godzzila),
            Movie(3, "Puppy Love", R.drawable.puppy_love),
            Movie(4, "Godzzila", R.drawable.godzzila),
            Movie(5, "Puppy Love", R.drawable.puppy_love),
            Movie(6, "Godzzila", R.drawable.godzzila),
        )
    )

    override suspend fun getMovieDetails(movieId: Int): MovieDetailsResponse = MovieDetailsResponse(
        //TODO: add all variables to MovieDetails and MovieDetailsResponse and create it here
        id = 2
    )

    override suspend fun getMovieCredits(movieId: Int): MovieCreditsResponse {
        //TODO: Change to server calls
        return MovieCreditsResponse()
    }

    override suspend fun getSearchMovie(query: String): MovieSearchResponse {
        //TODO: Change to server calls
        return MovieSearchResponse()
    }
}


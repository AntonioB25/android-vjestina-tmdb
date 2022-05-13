package com.e.tmdb.respository

import com.e.tmdb.models.movieCredits.MovieCredits
import com.e.tmdb.models.movieDetails.MovieDetails
import com.e.tmdb.networking.MovieApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface MovieDetailsRepository {
    fun getMovieDetails(movieId: Int): Flow<MovieDetails>
    fun getMovieCredits(movieId: Int): Flow<MovieCredits>
}

internal class MovieDetailsRepositoryImpl(
    private val movieApi: MovieApi
) : MovieDetailsRepository {
    override fun getMovieDetails(movieId: Int): Flow<MovieDetails> {
        return movieApi.getMovieDetails(movieId).map {
            it.movieDetails
        }
    }

    override fun getMovieCredits(movieId: Int): Flow<MovieCredits> {
        return movieApi.getMovieCredits(movieId).map {
            it.movieCredits
        }
    }
}
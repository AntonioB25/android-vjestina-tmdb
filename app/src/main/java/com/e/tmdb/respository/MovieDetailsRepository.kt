package com.e.tmdb.respository

import com.e.tmdb.models.movieCredits.MovieCredits
import com.e.tmdb.models.movieDetails.MovieDetails
import com.e.tmdb.networking.MovieApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface MovieDetailsRepository {
    suspend fun getMovieDetails(movieId: Int): Flow<MovieDetails>
    suspend fun getMovieCredits(movieId: Int): Flow<MovieCredits>
}

internal class MovieDetailsRepositoryImpl(
    private val movieApi: MovieApi
) : MovieDetailsRepository {
    override suspend fun getMovieDetails(movieId: Int): Flow<MovieDetails> {
        return flow {
            val movieDetails = movieApi.getMovieDetails(movieId).movieDetails
            emit(movieDetails)
        }
    }

    override suspend fun getMovieCredits(movieId: Int): Flow<MovieCredits> {
        return flow {
            val movieCredits = movieApi.getMovieCredits(movieId).movieCredits
            emit(movieCredits)
        }
    }
}
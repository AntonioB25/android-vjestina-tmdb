package com.e.tmdb.respository

import com.e.tmdb.models.movie.Movie
import com.e.tmdb.models.movie.toMovie
import com.e.tmdb.models.movieCredits.MovieCredits
import com.e.tmdb.models.movieCredits.toMovieCredits
import com.e.tmdb.models.movieDetails.MovieDetails
import com.e.tmdb.models.movieDetails.toMovieDetails
import com.e.tmdb.networking.MovieApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

interface MovieDetailsRepository {
    suspend fun getMovieDetails(movieId: Int): Flow<MovieDetails>
    suspend fun getMovieCredits(movieId: Int): Flow<MovieCredits>
    suspend fun getRecommendedMovies(movieId: Int): Flow<List<Movie>>
}

internal class MovieDetailsRepositoryImpl(
    private val movieApi: MovieApi
) : MovieDetailsRepository {
    override suspend fun getMovieDetails(movieId: Int): Flow<MovieDetails> {
        return flowOf(movieApi.getMovieDetails(movieId).toMovieDetails())
    }

    override suspend fun getMovieCredits(movieId: Int): Flow<MovieCredits> {
        return flowOf(movieApi.getMovieCredits(movieId).toMovieCredits())
    }

    override suspend fun getRecommendedMovies(movieId: Int): Flow<List<Movie>> {
        return flowOf(movieApi.getRecommendedMovies(movieId).movies.map { it.toMovie(false) })
    }
}
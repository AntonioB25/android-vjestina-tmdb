package com.e.tmdb.respository

import com.e.tmdb.models.movie.Movie
import com.e.tmdb.models.movie.toMovie
import com.e.tmdb.models.movieCredits.MovieCredits
import com.e.tmdb.models.movieCredits.toMovieCredits
import com.e.tmdb.models.movieDetails.MovieDetails
import com.e.tmdb.models.movieDetails.toMovieDetails
import com.e.tmdb.networking.MovieApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface MovieDetailsRepository {
    fun fetchMovieDetails(movieId: Int): Flow<MovieDetails>
    fun fetchMovieCredits(movieId: Int): Flow<MovieCredits>
    fun fetchRecommendedMovies(movieId: Int): Flow<List<Movie>>
}

internal class MovieDetailsRepositoryImpl(
    private val movieApi: MovieApi
) : MovieDetailsRepository {
    override fun fetchMovieDetails(movieId: Int): Flow<MovieDetails> =
        flow {
            emit(movieApi.fetchMovieDetails(movieId).toMovieDetails())
        }


    override fun fetchMovieCredits(movieId: Int): Flow<MovieCredits> =
        flow {
            emit(movieApi.fetchMovieCredits(movieId).toMovieCredits())
        }


    override fun fetchRecommendedMovies(movieId: Int): Flow<List<Movie>> =
        flow {
            emit(movieApi.fetchRecommendedMovies(movieId).movies.map { it.toMovie(false) })
        }

}
package com.e.tmdb.respository

import com.e.tmdb.models.movie.Movie
import com.e.tmdb.models.movieCredits.MovieCredits
import com.e.tmdb.models.movieDetails.MovieDetails
import com.e.tmdb.networking.MovieApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface MovieRepository {
    suspend fun getPopularMovies(): Flow<List<Movie>>
    suspend fun getTopRatedMovies(): Flow<List<Movie>>
    suspend fun getUpcomingMovies(): Flow<List<Movie>>
    suspend fun getNowPlayingMovies(): Flow<List<Movie>>
    suspend fun getMovieDetails(movieId: Int): Flow<MovieDetails>
    suspend fun getMovieCredits(movieId: Int): Flow<MovieCredits>
    suspend fun getSearchMovie(query: String): Flow<List<Movie>>
}

internal class MovieRepositoryImpl(
    private val movieApi: MovieApi
) : MovieRepository {

    override suspend fun getPopularMovies(): Flow<List<Movie>> {
        return flow {
            val popularMovies = movieApi.getPopularMovies().movies
            emit(popularMovies)
        }
    }

    override suspend fun getTopRatedMovies(): Flow<List<Movie>> {
        return flow {
            val popularMovies = movieApi.getTopRatedMovies().movies
            emit(popularMovies)
        }
    }

    override suspend fun getUpcomingMovies(): Flow<List<Movie>> {
        return flow {
            val popularMovies = movieApi.getUpcomingMovies().movies
            emit(popularMovies)
        }
    }

    override suspend fun getNowPlayingMovies(): Flow<List<Movie>> {
        return flow {
            val popularMovies = movieApi.getNowPlayingMovies().movies
            emit(popularMovies)
        }
    }

    override suspend fun getMovieDetails(movieId: Int): Flow<MovieDetails> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieCredits(movieId: Int): Flow<MovieCredits> {
        TODO("Not yet implemented")
    }

    override suspend fun getSearchMovie(query: String): Flow<List<Movie>> {
        TODO("Not yet implemented")
    }
}
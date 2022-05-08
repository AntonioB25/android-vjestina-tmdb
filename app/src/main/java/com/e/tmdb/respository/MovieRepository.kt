package com.e.tmdb.respository

import com.e.tmdb.database.FavouritesDatabase
import com.e.tmdb.models.movie.Movie
import com.e.tmdb.networking.MovieApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface MovieRepository {
    suspend fun getPopularMovies(): Flow<List<Movie>>
    suspend fun getTopRatedMovies(): Flow<List<Movie>>
    suspend fun getUpcomingMovies(): Flow<List<Movie>>
    suspend fun getNowPlayingMovies(): Flow<List<Movie>>
    suspend fun getSearchMovie(query: String): Flow<List<Movie>>
    fun addToFavourites(movie: Movie)
    fun removeFromFavourites(movie: Movie)
    fun getFavouriteMovies(): List<Movie>
}

internal class MovieRepositoryImpl(
    private val movieApi: MovieApi,
    private val favouritesDatabase: FavouritesDatabase
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

    override suspend fun getSearchMovie(query: String): Flow<List<Movie>> {
        TODO("Not yet implemented")
    }

    override fun addToFavourites(movie: Movie) {
        favouritesDatabase.favouriteMovies.add(movie)
    }

    override fun removeFromFavourites(movie: Movie) {
        favouritesDatabase.favouriteMovies.remove(movie)
    }

    override fun getFavouriteMovies(): List<Movie> {
        return favouritesDatabase.favouriteMovies
    }
}
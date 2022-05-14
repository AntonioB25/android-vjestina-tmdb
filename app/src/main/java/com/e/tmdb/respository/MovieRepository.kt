package com.e.tmdb.respository

import com.e.tmdb.database.FavouritesDatabase
import com.e.tmdb.models.movie.Movie
import com.e.tmdb.models.movie.toMovie
import com.e.tmdb.networking.MovieApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

interface MovieRepository {
    suspend fun getPopularMovies(): Flow<List<Movie>>
    suspend fun getTopRatedMovies(): Flow<List<Movie>>
    suspend fun getUpcomingMovies(): Flow<List<Movie>>
    suspend fun getNowPlayingMovies(): Flow<List<Movie>>
    suspend fun getSearchMovie(query: String): Flow<List<Movie>>
    suspend fun addToFavourites(movie: Movie)
    suspend fun removeFromFavourites(movie: Movie)
    suspend fun getFavouriteMovies(): Flow<MutableList<Movie>>
}

internal class MovieRepositoryImpl(
    private val movieApi: MovieApi,
    private val favouritesDatabase: FavouritesDatabase
) : MovieRepository {

    override suspend fun getPopularMovies(): Flow<List<Movie>> {
        return flowOf(movieApi.getPopularMovies().movies.map {
            it.toMovie(false)
        })
    }

    override suspend fun getTopRatedMovies(): Flow<List<Movie>> {
        return flowOf(movieApi.getTopRatedMovies().movies.map {
            it.toMovie(false)
        })
    }

    override suspend fun getUpcomingMovies(): Flow<List<Movie>> {
        return flowOf(movieApi.getUpcomingMovies().movies.map {
            it.toMovie(false)
        })
    }

    override suspend fun getNowPlayingMovies(): Flow<List<Movie>> {
        return flowOf(movieApi.getNowPlayingMovies().movies.map {
            it.toMovie(false)
        })
    }

    override suspend fun getSearchMovie(query: String): Flow<List<Movie>> {
        TODO("Not yet implemented")
    }

    override suspend fun addToFavourites(movie: Movie) {
        favouritesDatabase.favouriteMovies.add(movie)
    }

    override suspend fun removeFromFavourites(movie: Movie) {
        favouritesDatabase.favouriteMovies.remove(movie)
    }

    override suspend fun getFavouriteMovies(): Flow<MutableList<Movie>> {
        return flowOf(favouritesDatabase.favouriteMovies)
    }
}
package com.e.tmdb.respository

import com.e.tmdb.database.FavouritesDatabase
import com.e.tmdb.models.movie.Movie
import com.e.tmdb.models.movie.toMovie
import com.e.tmdb.networking.MovieApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

interface MovieRepository {
    fun getPopularMovies(): Flow<List<Movie>>
    fun getTopRatedMovies(): Flow<List<Movie>>
    fun getUpcomingMovies(): Flow<List<Movie>>
    fun getNowPlayingMovies(): Flow<List<Movie>>
    fun getSearchMovie(query: String): Flow<List<Movie>>
    fun addToFavourites(movie: Movie)
    fun removeFromFavourites(movie: Movie)
    fun getFavouriteMovies(): Flow<MutableList<Movie>>
}

internal class MovieRepositoryImpl(
    private val movieApi: MovieApi,
    private val favouritesDatabase: FavouritesDatabase
) : MovieRepository {

    override fun getPopularMovies(): Flow<List<Movie>> {
        return movieApi.getPopularMovies().map { it ->
            it.movies.map { it.toMovie(false) }
        }
    }

    override fun getTopRatedMovies(): Flow<List<Movie>> {
        return movieApi.getTopRatedMovies().map {
            it.movies
        }
    }

    override fun getUpcomingMovies(): Flow<List<Movie>> {
        return movieApi.getUpcomingMovies().map {
            it.movies
        }
    }

    override fun getNowPlayingMovies(): Flow<List<Movie>> {
        return movieApi.getNowPlayingMovies().map {
            it.movies
        }
    }

    override fun getSearchMovie(query: String): Flow<List<Movie>> {
        TODO("Not yet implemented")
    }

    override fun addToFavourites(movie: Movie) {
        favouritesDatabase.favouriteMovies.add(movie)
    }

    override fun removeFromFavourites(movie: Movie) {
        favouritesDatabase.favouriteMovies.remove(movie)
    }

    override fun getFavouriteMovies(): Flow<MutableList<Movie>> {
        return flowOf(favouritesDatabase.favouriteMovies)
    }
}
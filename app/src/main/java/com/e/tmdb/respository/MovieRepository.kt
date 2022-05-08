package com.e.tmdb.respository

import com.e.tmdb.database.FavouritesDatabase
import com.e.tmdb.models.movie.Movie
import com.e.tmdb.models.movie.toMovie
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
            val popularMovies = movieApi.getPopularMovies()
            val popular = mutableListOf<Movie>()
            popularMovies.movies.forEach { popular.add(it.toMovie(false)) }
            emit(popular)
        }
    }

    override suspend fun getTopRatedMovies(): Flow<List<Movie>> {
        return flow {
            val topRatedMovies = movieApi.getTopRatedMovies()
            val top = mutableListOf<Movie>()
            topRatedMovies.movies.forEach { top.add(it.toMovie(false)) }
            emit(top)
        }
    }

    override suspend fun getUpcomingMovies(): Flow<List<Movie>> {
        return flow {
            val upcomingMovies = movieApi.getUpcomingMovies()
            val upcoming = mutableListOf<Movie>()
            upcomingMovies.movies.forEach { upcoming.add(it.toMovie(false)) }
            emit(upcoming)
        }
    }

    override suspend fun getNowPlayingMovies(): Flow<List<Movie>> {
        return flow {
            val nowPlayingMovies = movieApi.getNowPlayingMovies()
            val nowPlaying = mutableListOf<Movie>()
            nowPlayingMovies.movies.forEach { nowPlaying.add(it.toMovie(false)) }
            emit(nowPlaying)
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
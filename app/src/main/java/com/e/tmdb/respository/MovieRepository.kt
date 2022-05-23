package com.e.tmdb.respository

import com.e.tmdb.database.FavouritesDatabase
import com.e.tmdb.models.movie.Movie
import com.e.tmdb.models.movie.toMovie
import com.e.tmdb.networking.MovieApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

interface MovieRepository {
    fun fetchPopularMovies(): Flow<List<Movie>>
    fun fetchTopRatedMovies(): Flow<List<Movie>>
    fun fetchUpcomingMovies(): Flow<List<Movie>>
    fun fetchNowPlayingMovies(): Flow<List<Movie>>
    fun fetchSearchMovie(query: String): Flow<List<Movie>>
    fun addToFavourites(movie: Movie)
    fun removeFromFavourites(movie: Movie)
    fun fetchFavouriteMovies(): Flow<MutableList<Movie>>
}

internal class MovieRepositoryImpl(
    private val movieApi: MovieApi,
    private val favouritesDatabase: FavouritesDatabase
) : MovieRepository {

    override fun fetchPopularMovies(): Flow<List<Movie>> =
        flow {
            emit(movieApi.fetchPopularMovies().movies.map {
                it.toMovie(false)
            })
        }


    override fun fetchTopRatedMovies(): Flow<List<Movie>> =
        flow {
            emit(movieApi.fetchTopRatedMovies().movies.map {
                it.toMovie(false)
            })
        }


    override
    fun fetchUpcomingMovies(): Flow<List<Movie>> =
        flow {
            emit(movieApi.fetchUpcomingMovies().movies.map {
                it.toMovie(false)
            })
        }


    override
    fun fetchNowPlayingMovies(): Flow<List<Movie>> =
        flow {
           emit( movieApi.fetchNowPlayingMovies().movies.map {
               it.toMovie(false)
           })
        }


    override
    fun fetchSearchMovie(query: String): Flow<List<Movie>> {
        TODO("Not yet implemented")
    }

    override
    fun addToFavourites(movie: Movie) {
        val newList = favouritesDatabase.favouriteMovies
        newList.add(movie)
        favouritesDatabase.favouriteMovies = newList
    }

    override
    fun removeFromFavourites(movie: Movie) {
        val newList = favouritesDatabase.favouriteMovies
        newList.remove(movie)
        favouritesDatabase.favouriteMovies = newList
    }

    override
    fun fetchFavouriteMovies(): Flow<MutableList<Movie>> =
        flowOf(favouritesDatabase.favouriteMovies)

}
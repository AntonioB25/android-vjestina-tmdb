package com.e.tmdb.networking

import android.util.Log
import com.e.tmdb.models.MovieSearchResponse
import com.e.tmdb.models.movie.MovieListResponse
import com.e.tmdb.models.movieCredits.MovieCreditsResponse
import com.e.tmdb.models.movieDetails.MovieDetailsResponse
import io.ktor.client.*
import io.ktor.client.request.*

interface MovieApi {
    suspend fun getPopularMovies(): MovieListResponse
    suspend fun getNowPlayingMovies(): MovieListResponse
    suspend fun getUpcomingMovies(): MovieListResponse
    suspend fun getTopRatedMovies(): MovieListResponse
    suspend fun getMovieDetails(movieId: Int): MovieDetailsResponse
    suspend fun getMovieCredits(movieId: Int): MovieCreditsResponse
    suspend fun getSearchMovie(query: String): MovieSearchResponse
    suspend fun getRecommendedMovies(movieId: Int): MovieListResponse
}

internal class MovieApiImpl(
    private val client: HttpClient
) : MovieApi {


    override suspend fun getPopularMovies(): MovieListResponse =
        client.get(
            "${HttpRoutes.POPULAR_MOVIES}?api_key=${HttpRoutes.API_KEY}"
        )


    override suspend fun getNowPlayingMovies(): MovieListResponse =
        client.get(
            "${HttpRoutes.NOW_PLAYING_MOVIES}?api_key=${HttpRoutes.API_KEY}"
        )

    override suspend fun getUpcomingMovies(): MovieListResponse =
        client.get(
            "${HttpRoutes.UPCOMING_MOVIES}?api_key=${HttpRoutes.API_KEY}"
        )

    override suspend fun getTopRatedMovies(): MovieListResponse =
        client.get(
            "${HttpRoutes.TOP_RATED_MOVIES}?api_key=${HttpRoutes.API_KEY}"
        )

    override suspend fun getMovieDetails(movieId: Int): MovieDetailsResponse =
        client.get(
            "${HttpRoutes.BASE_URL}/movie/$movieId?api_key=${HttpRoutes.API_KEY}"
        )

    override suspend fun getMovieCredits(movieId: Int): MovieCreditsResponse =
        client.get(
            "${HttpRoutes.BASE_URL}/movie/$movieId/credits?api_key=${HttpRoutes.API_KEY}"
        )

    override suspend fun getSearchMovie(query: String): MovieSearchResponse =
        client.get(
            "${HttpRoutes.BASE_URL}/search/movie/?query=$query?api_key=${HttpRoutes.API_KEY}"
        )

    override suspend fun getRecommendedMovies(movieId: Int): MovieListResponse =
        client.get(
            "${HttpRoutes.BASE_URL}/movie/$movieId/recommendations?api_key=${HttpRoutes.API_KEY}"
        )

}


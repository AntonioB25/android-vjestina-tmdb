package com.e.tmdb.networking

object HttpRoutes {
    const val API_KEY = "e5e804da933195753a86e58505c0beee"
    const val BASE_URL = "https://api.themoviedb.org/3"
    const val POPULAR_MOVIES = "${BASE_URL}/movie/popular"
    const val NOW_PLAYING_MOVIES = "${BASE_URL}/movie/now_playing"
    const val UPCOMING_MOVIES = "${BASE_URL}/movie/upcoming"
    const val TOP_RATED_MOVIES = "${BASE_URL}/movie/top_rated"
}
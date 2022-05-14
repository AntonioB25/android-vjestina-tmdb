package com.e.tmdb.models.movie

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    var isFavorite: Boolean
)

const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500/"

fun MovieResponse.toMovie(isFavorite: Boolean) = Movie(
    id,
    title,
    overview,
    posterPath.let { "$BASE_IMAGE_URL/$it" },
    isFavorite
)
package com.e.tmdb.models.movie

data class Movie(
    val id: Int,
    val title: String,
    val imageUrl: Int,
    var isFavorite: Boolean = false
)

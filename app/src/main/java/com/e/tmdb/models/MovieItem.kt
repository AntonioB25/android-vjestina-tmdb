package com.e.tmdb.models

data class MovieItem(
    val id: Int,
    val title: String,
    val imageUrl: Int,
    var isFavorite: Boolean = false
)

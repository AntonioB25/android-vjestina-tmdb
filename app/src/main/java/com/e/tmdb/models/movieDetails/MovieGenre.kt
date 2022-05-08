package com.e.tmdb.models.movieDetails

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieGenre(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)
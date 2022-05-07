package com.e.tmdb.models.movieDetails

import com.e.tmdb.models.Genre
import com.e.tmdb.models.ProductionCountry

data class MovieDetails(
    val id: Int,
    val title: String,
    val backDropPath: String?,
    val posterPath: String,
    val genres: List<Genre>,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val releaseDate: String,
    val runtime: Int?,
    val productionCountries: List<ProductionCountry>
)

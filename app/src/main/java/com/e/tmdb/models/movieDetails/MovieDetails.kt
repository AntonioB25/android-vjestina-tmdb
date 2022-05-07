package com.e.tmdb.models.movieDetails

data class MovieDetails(
    val id: Int,
    val title: String,
    val backDropPath: String?,
    val posterPath: String,
    val genres: List<MovieGenre>,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val releaseDate: String,
    val runtime: Int?,
    val productionCountries: List<ProductionCountry>
)

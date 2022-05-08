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

fun MovieDetailsResponse.toMovieDetails() = MovieDetails(
    id,
    title,
    backDropPath,
    posterPath,
    genres,
    originalLanguage,
    originalTitle,
    overview,
    releaseDate,
    runtime,
    productionCountries
)
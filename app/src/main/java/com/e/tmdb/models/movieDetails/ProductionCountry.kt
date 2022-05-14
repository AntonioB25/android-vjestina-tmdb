package com.e.tmdb.models.movieDetails

data class ProductionCountry(
    val iso: String,
    val name: String
)

fun ProductionCountryResponse.toProductionCompany() = ProductionCountry(
    iso, name
)
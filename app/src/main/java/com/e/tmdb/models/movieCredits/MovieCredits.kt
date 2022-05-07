package com.e.tmdb.models.movieCredits

data class MovieCredits(
    val id: Int,
    val cast: List<CastMember>,
    val crew: List<CrewMember>
)
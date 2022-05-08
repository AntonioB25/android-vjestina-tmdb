package com.e.tmdb.models.movieCredits

data class CastMember(
    val id: Int,
    val name: String,
    val characterName: String,
    val profilePath: String,
)

fun CastMemberResponse.toCastMember() = CastMember(
    id,
    name,
    characterName,
    profilePath
)
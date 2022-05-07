package com.e.tmdb.models.movieCredits

data class CastMember(
    val id: Int,
    val name: String,
    val characterName: String,      // SerialName (character)
    val imageUrl: String,              // SerialName (profile_path)
    val gender: Int?,
    val castId: Int,                // maybe not needed
    val creditId: Int,              // maybe not needed
    val knownForDepartment: String, // maybe not needed
    val adult: Boolean,             // maybe not needed
    val order: Int                  // maybe not needed
)

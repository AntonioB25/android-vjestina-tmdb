package com.e.tmdb.models.movieCredits

data class CrewMember(
    val id: Int,
    val name: String,
    val gender: Int?,
    val job: String,
    val department: String,
    val knownForDepartment: String, // maybe not needed
    val characterName: String,      // SerialName (character)
    val imageUrl: Int,              // SerialName (profile_path)
)
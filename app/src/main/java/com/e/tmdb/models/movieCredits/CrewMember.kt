package com.e.tmdb.models.movieCredits

data class CrewMember(
    val id: Int,
    val name: String,
    val job: String,
    val department: String,
    val profilePath: String,
)

fun CrewMemberResponse.toCrewMember() = CrewMember(
    id,
    name,
    job,
    department,
    profilePath
)
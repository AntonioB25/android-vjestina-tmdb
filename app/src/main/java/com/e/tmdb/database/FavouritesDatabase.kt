package com.e.tmdb.database

import com.e.tmdb.models.movie.Movie

data class FavouritesDatabase(
    var favouriteMovies: MutableList<Movie>,
)

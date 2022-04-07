package com.e.tmdb.ui.screens

import androidx.compose.runtime.Composable
import com.e.tmdb.ui.components.MovieDetails

@Composable
fun DetailsScreen(moveId: Int?) {

    MovieDetails(id = moveId)
}
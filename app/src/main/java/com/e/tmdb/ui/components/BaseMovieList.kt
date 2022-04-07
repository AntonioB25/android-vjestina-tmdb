package com.e.tmdb.ui.components

import MovieCard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.e.tmdb.models.MovieItem

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BaseMovieList(
    list: List<MovieItem>,
    navigateToDetails: (Int?) -> Unit
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(list) { movie ->
            MovieCard(modifier = Modifier, item = movie, navigateToDetails)
        }
    }
}
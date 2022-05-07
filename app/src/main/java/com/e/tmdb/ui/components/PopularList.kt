package com.e.tmdb.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.e.tmdb.models.movie.Movie
import com.e.tmdb.viewModel.HomeViewModel
import org.koin.androidx.compose.getViewModel

/**
 * Shows list of popular movies
 * Uses MovieList to show MovieCards
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PopularList(
    movieList: List<Movie>,
    navigateToDetails: (Int) -> Unit,
) {
    val homeViewModel = getViewModel<HomeViewModel>()
    var movies by remember {
        mutableStateOf(
            movieList
        )
    }

    Column {

        Text(
            text = "What's popular",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(start = 10.dp)
        )
        Row {
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                elevation = null,
                onClick = {
                    movies = homeViewModel.getPopularMovies()
                },
            ) {
                Text(text = "Popular", style = MaterialTheme.typography.h2)
            }
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                elevation = null,
                onClick = {
                    movies = homeViewModel.getTopRatedMovies()
                }
            ) {
                Text(text = "Top rated", style = MaterialTheme.typography.h2)
            }
        }

        MovieList(list = movies, navigateToDetails = navigateToDetails)
    }
}

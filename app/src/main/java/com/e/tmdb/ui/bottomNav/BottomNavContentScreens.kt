package com.e.tmdb.ui.bottomNav

import MovieCard
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.e.tmdb.models.MovieItem
import com.e.tmdb.R
import com.e.tmdb.ui.components.BaseMovieList
import com.e.tmdb.ui.components.PopularList
import com.e.tmdb.ui.components.SearchBar


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Home(navigateToDetails: (Int?) -> Unit) {
    var moviesList: MutableList<MovieItem> = mutableListOf(
        MovieItem(1, "Ironman", R.drawable.ironman),
        MovieItem(2, "Godzzila", R.drawable.godzzila),
        MovieItem(3, "Puppy Love", R.drawable.puppy_love),
        MovieItem(4, "Ironman", R.drawable.ironman),
        MovieItem(5, "Godzzila", R.drawable.godzzila),
        MovieItem(6, "Puppy Love", R.drawable.puppy_love)
    )
    LazyColumn(

    ) {
        item {
            Column(
            ) {
                SearchBar(
                    text = "",
                    onTextChange = {},
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                PopularList(movieList = moviesList, navigateToDetails = navigateToDetails)

                Text(
                    text = "Now playing",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.padding(start = 10.dp)
                )
                BaseMovieList(list = moviesList, navigateToDetails = navigateToDetails)

                Text(
                    text = "Upcoming",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.padding(start = 10.dp)
                )
                BaseMovieList(list = moviesList, navigateToDetails = navigateToDetails)

                Spacer(modifier = Modifier.padding(24.dp))
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class, androidx.compose.material.ExperimentalMaterialApi::class)
@Composable
fun FavouritesScreen(navigateToDetails: (Int?) -> Unit) {
    var favourites = mutableListOf(
        MovieItem(1, "Ironman", R.drawable.ironman),
        MovieItem(2, "Godzzila", R.drawable.godzzila),
        MovieItem(3, "Puppy Love", R.drawable.puppy_love),
        MovieItem(2, "Godzzila", R.drawable.godzzila),
        MovieItem(3, "Puppy Love", R.drawable.puppy_love)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Favorites",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(start = 10.dp)
        )

        Spacer(modifier = Modifier.padding(20.dp))
        LazyVerticalGrid(
            cells = GridCells.Adaptive(minSize = 120.dp),
        ) {
            items(favourites) { movie ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(5.dp)
                ) {
                    MovieCard(item = movie, navigateToDetails = navigateToDetails)
                }

            }
        }
    }
}
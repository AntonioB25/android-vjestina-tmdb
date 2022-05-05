package com.e.tmdb.ui.bottomNav

import MovieCard
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.e.tmdb.R
import com.e.tmdb.models.MovieItem
import com.e.tmdb.ui.components.MovieList
import com.e.tmdb.ui.components.PopularList
import com.e.tmdb.ui.components.SearchBar


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Home(navigateToDetails: (Int) -> Unit) {
    var moviesList: MutableList<MovieItem> = mutableListOf(
        MovieItem(1, "Ironman", R.drawable.ironman),
        MovieItem(2, "Godzzila", R.drawable.godzzila),
        MovieItem(3, "Puppy Love", R.drawable.puppy_love),
        MovieItem(4, "Ironman", R.drawable.ironman),
        MovieItem(5, "Godzzila", R.drawable.godzzila),
        MovieItem(6, "Puppy Love", R.drawable.puppy_love)
    )

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        SearchBar(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        PopularList(movieList = moviesList, navigateToDetails = navigateToDetails)

        MovieCategory(
            categoryTitle = stringResource(id = R.string.category_now_playing),
            movieList = moviesList,
            navigateToDetails = navigateToDetails
        )

        MovieCategory(
            categoryTitle = stringResource(id = R.string.category_upcoming),
            movieList = moviesList,
            navigateToDetails = navigateToDetails
        )

        Spacer(modifier = Modifier.padding(24.dp))
    }
}

@Composable
fun MovieCategory(
    categoryTitle: String,
    movieList: List<MovieItem>,
    navigateToDetails: (Int) -> Unit
) {
    Text(
        text = categoryTitle,
        style = MaterialTheme.typography.h1,
        modifier = Modifier.padding(start = 10.dp)
    )
    MovieList(list = movieList, navigateToDetails = navigateToDetails)
}


@OptIn(ExperimentalFoundationApi::class, androidx.compose.material.ExperimentalMaterialApi::class)
@Composable
fun FavouritesScreen(navigateToDetails: (Int) -> Unit) {
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
            text = stringResource(id = R.string.label_favourites),
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(start = 10.dp)
        )

        Spacer(modifier = Modifier.padding(20.dp))
        LazyVerticalGrid(
            cells = GridCells.Adaptive(minSize = 120.dp),
        ) {
            items(favourites) { movie ->
                MovieCard(
                    item = movie,
                    modifier = Modifier.padding(5.dp),
                    navigateToDetails = navigateToDetails
                )
            }
        }
    }
}
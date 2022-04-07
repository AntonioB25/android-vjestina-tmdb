package com.e.tmdb.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.e.tmdb.models.MovieItem
import com.e.tmdb.R

/**
 * Shows list of popular movies
 * Uses BaseMovieList to show MovieCards
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PopularList(
    movieList: MutableList<MovieItem>,
    navigateToDetails: (Int?) -> Unit
) {
    var movies by remember {
        mutableStateOf(
            listOf(
                MovieItem(1, "Ironman", R.drawable.ironman),
                MovieItem(2, "Godzzila", R.drawable.godzzila),
                MovieItem(1, "Ironman", R.drawable.ironman),
                MovieItem(2, "Godzzila", R.drawable.godzzila),
                MovieItem(1, "Ironman", R.drawable.ironman),
                MovieItem(2, "Godzzila", R.drawable.godzzila),
                MovieItem(3, "Puppy Love", R.drawable.puppy_love)
            )
        )
    }
    var popularList = mutableListOf<MovieItem>(
        MovieItem(1, "Ironman", R.drawable.ironman),
        MovieItem(2, "Godzzila", R.drawable.godzzila),
        MovieItem(1, "Ironman", R.drawable.ironman),
        MovieItem(2, "Godzzila", R.drawable.godzzila),
        MovieItem(1, "Ironman", R.drawable.ironman),
        MovieItem(2, "Godzzila", R.drawable.godzzila),
        MovieItem(3, "Puppy Love", R.drawable.puppy_love)
    )

    var topRatedList = mutableListOf<MovieItem>(
        MovieItem(3, "Puppy Love", R.drawable.puppy_love),
        MovieItem(2, "Godzzila", R.drawable.godzzila),
        MovieItem(3, "Puppy Love", R.drawable.puppy_love),
        MovieItem(2, "Godzzila", R.drawable.godzzila),
        MovieItem(3, "Puppy Love", R.drawable.puppy_love),
        MovieItem(2, "Godzzila", R.drawable.godzzila),
    )

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
                    movies = popularList
                },
            ) {
                Text(text = "Popular", style = MaterialTheme.typography.h2)
            }
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                elevation = null,
                onClick = {
                    movies = topRatedList
                }
            ) {
                Text(text = "Top rated", style = MaterialTheme.typography.h2)
            }
        }

        BaseMovieList(list = movies, navigateToDetails = navigateToDetails)
    }
}

//@Composable
//@Preview
//fun prevList() {
//
//    PopularList(emptyList<MovieItem>() as MutableList<MovieItem>, navigateToDetails)
//}
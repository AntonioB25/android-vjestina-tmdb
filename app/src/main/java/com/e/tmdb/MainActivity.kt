package com.e.tmdb

import MovieCard
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.e.tmdb.models.movie.Movie
import com.e.tmdb.ui.components.MovieList
import com.e.tmdb.ui.screens.MainScreen
import com.e.tmdb.ui.theme.TMDBTheme
import com.e.tmdb.viewModel.HomeViewModel
import kotlinx.coroutines.flow.collect
import org.koin.android.ext.android.get
import org.koin.androidx.compose.getViewModel
import org.koin.core.context.GlobalContext.get

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController() // main screen controller
            fun navigateToDetails(id: Int?) {
                navController.navigate("details/${id}")
            }
            TMDBTheme {
                MainScreen(
                    navController = navController,
                    navigateToDetails = ::navigateToDetails,
                )

            }
        }
    }

}

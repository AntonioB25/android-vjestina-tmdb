package com.e.tmdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.e.tmdb.networking.MovieApiImpl
import com.e.tmdb.respository.MovieRepositoryImpl
import com.e.tmdb.ui.screens.MainScreen
import com.e.tmdb.ui.theme.TMDBTheme
import com.e.tmdb.viewModel.HomeViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val homeViewModel: HomeViewModel by viewModel()

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
                    homeViewModel = homeViewModel
                )
            }
        }
    }


}

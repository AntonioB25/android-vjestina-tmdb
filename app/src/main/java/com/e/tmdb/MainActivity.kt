package com.e.tmdb

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.e.tmdb.ui.screens.MainScreen
import com.e.tmdb.ui.theme.TMDBTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController() // main screen controller (služi za mijenjanje između HomeScreen, DetailsScreen, i kasnije Settings?)

            fun navigateToDetails(id: Int?){
                Log.e("key", id.toString())
                navController.navigate("details/${id}")
            }


            TMDBTheme {
               MainScreen(navController = navController, navigateToDetails = ::navigateToDetails)
            }
        }
    }


}

package com.e.tmdb.ui.bottomNav

import android.content.res.Resources
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.e.tmdb.R

sealed class BottomNavItem(
    var title: String,
    var selectedIcon: ImageVector,
    var unselectedIcon: ImageVector,
    var screen_route: String
) {
    object Home : BottomNavItem(
       //Resources.getSystem().getString(R.string.label_home),
        "Home",
        Icons.Default.Home,
        Icons.Outlined.Home,
        "home"
       //Resources.getSystem().getString(R.string.route_home)
    )

    object Favourites : BottomNavItem(
        "Favourites",
        //Resources.getSystem().getString(R.string.label_favourites),
        Icons.Default.Favorite,
        Icons.Default.FavoriteBorder,
        "favourites"
        //Resources.getSystem().getString(R.string.route_favourites)
    )
}
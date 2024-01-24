package com.hfad.allmovie.presentation.navigation.bottom_navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hfad.allmovie.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector

) {
    object Home : BottomBarScreen(
        title = "Home",
        route = "home",
        icon = Icons.Default.Home
    )

    object Search : BottomBarScreen(
        title = "Search",
        route = "search",
        icon = Icons.Default.Search
    )

    object WatchList : BottomBarScreen(
        title = "Watch List",
        route = "watch_list",
        icon = Icons.Default.List
    )
}

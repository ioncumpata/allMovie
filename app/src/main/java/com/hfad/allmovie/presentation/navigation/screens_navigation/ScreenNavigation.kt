package com.hfad.allmovie.presentation.navigation.screens_navigation

sealed class ScreenNavigation(val route : String){
    object DetailsScreen: ScreenNavigation("detail_screen")
}

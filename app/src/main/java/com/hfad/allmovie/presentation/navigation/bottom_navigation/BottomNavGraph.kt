package com.hfad.allmovie.presentation.navigation.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hfad.allmovie.presentation.detailsmovie_screen.DetailsMovieScreen
import com.hfad.allmovie.presentation.home_screen.HomeScreen
import com.hfad.allmovie.presentation.navigation.screens_navigation.ScreenNavigation
import com.hfad.allmovie.presentation.search_screen.SearchScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.BOTTOM,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navHostController = navController)
        }
        composable(route = BottomBarScreen.Search.route) {
            SearchScreen(navHostController = navController)
        }

        detailsNavGraph(navController)


    }


}



fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = ScreenNavigation.DetailsScreen.route+ "/{movieId}"
    ) {


        composable(route = ScreenNavigation.DetailsScreen.route+"/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })) {
            DetailsMovieScreen(navController = navController)

            navController.popBackStack(
                route = ScreenNavigation.DetailsScreen.route+"/{movieId}",
                inclusive = false
            )
        }
    }
}


object Graph {
    const val BOTTOM = "bottom_graph"
    const val DETAILS = "details_graph"

}





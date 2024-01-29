package com.hfad.allmovie.presentation.home_screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestinationDsl
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.hfad.allmovie.presentation.navigation.bottom_navigation.BottomBarScreen
import com.hfad.allmovie.presentation.navigation.screens_navigation.ScreenNavigation

@NavDestinationDsl
@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    navHostController: NavHostController


) {

    val movies = viewModel.moviesPage.value.collectAsLazyPagingItems()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(movies.itemCount) { movieItem ->

                movies[movieItem]?.let {



                    MovieItem(
                        movie = it,
                        viewModel = viewModel,
                        onClick = { movieId ->
                            navHostController.navigate(route = ScreenNavigation.DetailsScreen.route + "/$movieId")


                        }

                    )
                }
            }
        }
    }
}



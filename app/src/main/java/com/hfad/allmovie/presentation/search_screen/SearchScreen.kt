package com.hfad.allmovie.presentation.search_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.hfad.allmovie.presentation.navigation.screens_navigation.ScreenNavigation
import com.hfad.allmovie.presentation.search_screen.components.SearchBar
import com.hfad.allmovie.presentation.search_screen.components.SearchItem
import com.hfad.allmovie.ui.theme.PurplyBlue


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel = hiltViewModel(),
    navHostController: NavHostController
) {

    val movieList = searchViewModel.state.value.movies



    Column(
        Modifier.fillMaxSize(),

    ) {
        Scaffold(topBar = {
            SearchBar(onCloseClicked = { },
                onSearchClicked = { searchViewModel.getMovie(it) })

        }, backgroundColor = PurplyBlue) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(vertical = 10.dp),
            ) {

                itemsIndexed(items = movieList ?: emptyList()) { index, item ->

                    SearchItem(searchItem = item, onClick = { movieId ->
                        navHostController.navigate(route = ScreenNavigation.DetailsScreen.route+ "/$movieId")})

                }


            }

        }


    }
}



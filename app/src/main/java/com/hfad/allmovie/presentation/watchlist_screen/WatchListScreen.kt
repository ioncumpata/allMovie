package com.hfad.allmovie.presentation.watchlist_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.hfad.allmovie.presentation.watchlist_screen.components.WatchListMovieScreenItem

@Composable
fun WatchListScreen( viewModel: WatchListViewModel = hiltViewModel()) {

    val movies = viewModel.state.value

    LazyColumn(modifier = Modifier.fillMaxSize()){

        movies.movies?.size?.let { items(it){

                WatchListMovieScreenItem(watchListItem = movies.movies[it] , onClick ={} )

        } }
    }

}
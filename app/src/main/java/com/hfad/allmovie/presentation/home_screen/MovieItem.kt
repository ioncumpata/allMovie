package com.hfad.allmovie.presentation.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.hfad.allmovie.R
import com.hfad.allmovie.domain.model.allmovies.Movie
import com.hfad.allmovie.domain.model.watch_list.WatchListItem


@Composable
fun MovieItem(
    movie: Movie,
    onClick: (String) -> Unit,
    viewModel: HomeScreenViewModel,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .height(200.dp)
            .padding(8.dp)
    ) {


        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = movie.img,
                contentDescription = "Movie Poster",
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { onClick(movie.id) },
            )
            BookmarkButton(
                movie = movie,
                viewModel = viewModel,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 70.dp),

                )


        }
    }
}


@Composable
fun BookmarkButton(
    modifier: Modifier,
    movie: Movie,
    viewModel: HomeScreenViewModel,

    ) {

    LaunchedEffect(movie.id){
        viewModel.ifExistMovieInWatchList(movie.id)
    }

    val isBookmarked = remember { viewModel.getBookmarkState(movie.id) }


    if (!isBookmarked.value) {

        Image(
            painter = painterResource(id = R.drawable.baseline_bookmark_border_24),
            contentDescription = "Add",
            modifier = Modifier
                .size(50.dp)
                .padding(2.dp)
                .clickable {
                    viewModel.addMovieToWatchList(
                        watchListItem = WatchListItem(
                            id = movie.id,
                            img = movie.img,
                            header = movie.text
                                .substringBefore("(")
                                .substringAfter("Download")
                        )
                    )
                    isBookmarked.value = true

                }

        )


    } else {


        Image(
            painter = painterResource(id = R.drawable.baseline_bookmark_added_24),
            contentDescription = "Add",
            modifier = Modifier
                .size(70.dp)
                .padding(9.dp)
                .clickable {
                    viewModel.removeMovieFromWatchList(movie.id)

                    isBookmarked.value = false


                })


    }
}









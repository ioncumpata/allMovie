package com.hfad.allmovie.presentation.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.hfad.allmovie.domain.model.allmovies.Movie


@Composable
fun MovieItem(movie: Movie) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .height(200.dp)
            .padding(8.dp)
    ) {

            AsyncImage(
                model = movie.img,
                contentDescription = "Movie Poster",
                modifier = Modifier
                    .fillMaxSize()

            )


    }
}





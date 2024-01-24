package com.hfad.allmovie.presentation.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.hfad.allmovie.domain.model.allmovies.Movie


@Composable
fun MovieItem(movie: Movie,  onClick: (String) -> Unit) {
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
                    .clickable { onClick(movie.id) },
            )



    }
}






package com.hfad.allmovie.presentation.detailsmovie_screen.components



import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hfad.allmovie.domain.model.movie_details.MovieDetails

@Composable
fun TopDetailBar(navController: NavHostController, title:MovieDetails) {
    TopAppBar(
        title = { Text(
            text =  title.header.substringBefore("(").substringAfter("Download"),
            style = MaterialTheme.typography.body1,
            color = Color.Cyan,
            modifier = Modifier.padding(start = 30.dp)
        ) },
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.Cyan
                )
            }
        },
        backgroundColor = Color.Black
    )

}
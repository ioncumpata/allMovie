package com.hfad.allmovie.presentation.detailsmovie_screen.components

import android.graphics.Paint.Style
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.hfad.allmovie.domain.model.movie_details.MovieDetails

@Composable
fun Details(details: MovieDetails) {

    LazyColumn(modifier = Modifier.fillMaxSize()) {


        item {
            Row() {
                Text(
                    text = "Title : ",
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(20.dp)

                    )
                details.header.let { header ->
                    Text(
                        text = header.substringBefore("(").substringAfter("Download"),
                        style = MaterialTheme.typography.h5,
                        color = Color.White,
                        modifier = Modifier.padding(start = 40.dp , top = 10.dp)

                    )
                }

            }

        }

        item {
            Row(modifier = Modifier.padding(20.dp)) {

                Text(text = "Release Year : ")

                details.header.let { header ->
                    Text(
                        text = header.substringBefore(")").substringAfter("("),
                        color = Color.White

                    )


                }
            }
        }


        item {

            Text(text = "Storyline : ", modifier = Modifier.padding(start = 20.dp))
            details.storyLine.let { storyLine ->
                Text(
                    text = storyLine,
                    modifier = Modifier.padding(10.dp),
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.padding(40.dp))


        }

        item() {


            AsyncImage(
                model = details.screenShots,
                contentDescription = "Screenshot of movie",
                modifier = Modifier.fillMaxWidth()
            )

        }
    }
}


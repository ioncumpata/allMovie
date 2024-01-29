package com.hfad.allmovie.presentation.watchlist_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.hfad.allmovie.R
import com.hfad.allmovie.domain.model.watch_list.WatchListItem

@Composable
fun WatchListMovieScreenItem(watchListItem: WatchListItem, onClick: (String) -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .height(200.dp)
            .padding(8.dp)
    ) {

        Box(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.fillMaxSize()) {
                AsyncImage(
                    model = watchListItem.img,
                    contentDescription = "Movie Poster",
                    modifier = Modifier
                        .height(190.dp)
                        .width(130.dp)

                )

                Text(text = watchListItem.header)


            }
            IconButton(
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_delete_24),
                        contentDescription = "Delete"
                    )
                },
                onClick = {  onClick(watchListItem.id) },
                modifier = Modifier.padding(
                    start = 320.dp,
                    top = 140.dp
                )
            )


        }
    }
}

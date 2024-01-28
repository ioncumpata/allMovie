package com.hfad.allmovie.presentation.watchlist_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.hfad.allmovie.domain.model.watch_list.WatchListItem
import com.hfad.allmovie.presentation.home_screen.BookmarkButton

@Composable
fun WatchListMovieScreenItem(watchListItem: WatchListItem, onClick: (String) -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .height(200.dp)
            .padding(8.dp)
    ) {

        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = watchListItem.img,
                contentDescription = "Movie Poster",
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { onClick(watchListItem.id) },
            )

            Text(text = watchListItem.header)


        }
    }
}

package com.hfad.allmovie.presentation.search_screen.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.hfad.allmovie.domain.model.search_movie.SearchMovie
import com.hfad.allmovie.ui.theme.SearchItemBackColor

@Composable
fun SearchItem(
    searchItem: SearchMovie?,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit,
) {

        Card(
            modifier = modifier
                .fillMaxWidth()
                .height(350.dp)
                .padding(10.dp)
                .clickable { searchItem?.id?.let { onClick(it) } },
            shape = RectangleShape,


        ) {
              AsyncImage(
                  model = searchItem?.img,
                  contentDescription = "Item Image",
                  modifier = Modifier.fillMaxSize()
              )


        }
    }


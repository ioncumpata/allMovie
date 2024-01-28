package com.hfad.allmovie.presentation.watchlist_screen

import com.hfad.allmovie.domain.model.search_movie.SearchMovie
import com.hfad.allmovie.domain.model.watch_list.WatchListItem

data class WatchListState(
    val isLoading: Boolean = false,
    val movies: List<WatchListItem>? = emptyList(),
    val isError: String = ""
)

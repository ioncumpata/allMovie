package com.hfad.allmovie.presentation.search_screen

import com.hfad.allmovie.domain.model.search_movie.SearchMovie

data class SearchMovieState(
    val isLoading: Boolean = false,
    val movies: List<SearchMovie>? = emptyList(),
    val isError: String = ""
)
package com.hfad.allmovie.presentation.detailsmovie_screen

import com.hfad.allmovie.domain.model.movie_details.MovieDetails

data class DetailsListState(
    val isLoading: Boolean = false,
    val movieDetails: MovieDetails? = null,
    val isError: String = ""
)

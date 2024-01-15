package com.hfad.allmovie.presentation.home_screen

import com.hfad.allmovie.domain.model.allmovies.AllMovies
import com.hfad.allmovie.domain.model.allmovies.Movie

data class AllMoviesState(
    val isLoading: Boolean = false,
    val allMoviesList: List<Movie> = emptyList(),
    val isError: String = ""
)

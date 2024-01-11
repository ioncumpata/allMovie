package com.hfad.allmovie.domain.model.allmovies

data class AllMovies(
    val movies: List<Movie>,
    val totalPages: Int
)
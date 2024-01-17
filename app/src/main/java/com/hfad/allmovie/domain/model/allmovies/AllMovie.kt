package com.hfad.allmovie.domain.model.allmovies

import com.hfad.allmovie.data.remote.dto.allmovies_dto.MovieDto

data class AllMovie(
    val itemsPerPage: Int,
    val movies: List<Movie>,
    val totalPages: Int
)
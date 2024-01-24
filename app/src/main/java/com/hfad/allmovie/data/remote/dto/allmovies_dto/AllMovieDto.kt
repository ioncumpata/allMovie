package com.hfad.allmovie.data.remote.dto.allmovies_dto

import com.hfad.allmovie.domain.model.allmovies.AllMovie

data class AllMovieDto(
    val itemsPerPage: Int,
    val movies: List<MovieDto>,
    val totalPages: Int
)
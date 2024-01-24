package com.hfad.allmovie.data.remote.dto.search_movie_dto

data class MainSearchDto(
    val itemsPerPage: Int,
    val movies: List<SearchMovieDto>,
    val totalPages: Int
)
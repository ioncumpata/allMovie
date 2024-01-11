package com.hfad.allmovie.data.remote.dto.allmovies_dto

import com.hfad.allmovie.domain.model.allmovies.AllMovies

data class AllMoviesDto(
    val itemsPerPage: Int,
    val movies: List<MovieDto>,
    val totalPages: Int
){
    fun toAllMovies(): AllMovies{
        return AllMovies(
            movies = movies.map { it.toMovie() },
            totalPages = totalPages
        )
    }
}
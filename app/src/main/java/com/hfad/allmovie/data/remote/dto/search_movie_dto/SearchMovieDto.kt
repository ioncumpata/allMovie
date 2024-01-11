package com.hfad.allmovie.data.remote.dto.search_movie_dto

import com.hfad.allmovie.domain.model.search_movie.SearchMovie

data class SearchMovieDto(
    val id: String,
    val img: String,
    val link: String,
    val text: String
){
    fun toSearchMovie(): SearchMovie{
        return SearchMovie(
            text = text,
            img = img,
            id = id
        )
    }
}
package com.hfad.allmovie.data.remote.dto.allmovies_dto

import com.hfad.allmovie.data.local.entities.movies_entity.MoviesEntity
import com.hfad.allmovie.domain.model.allmovies.Movie

data class MovieDto(
    val id: String,
    val img: String,
    val link: String,
    val text: String
){

    fun toMovie(): Movie{
        return Movie(
            id = id,
            img = img,
            text = text
        )
    }

    fun toMoviesEntity(): MoviesEntity{
        return MoviesEntity(
            id = id,
            img = img,
            text = text
        )
    }
}
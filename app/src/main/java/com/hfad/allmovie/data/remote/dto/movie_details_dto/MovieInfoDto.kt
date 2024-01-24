package com.hfad.allmovie.data.remote.dto.movie_details_dto

import com.hfad.allmovie.domain.model.movie_details.MovieInfo

data class MovieInfoDto(
    val highlighter : String,
    val info: String
){

    fun toMovieInfo(): MovieInfo{
        return MovieInfo(
            highlighter = highlighter,
            info = info
        )
    }
}
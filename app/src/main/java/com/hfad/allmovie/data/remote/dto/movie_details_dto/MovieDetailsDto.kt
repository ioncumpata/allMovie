package com.hfad.allmovie.data.remote.dto.movie_details_dto

import com.hfad.allmovie.domain.model.movie_details.MovieDetails

data class MovieDetailsDto(
    val extraInfoDto: List<ExtraInfoDto>,
    val header: String,
    val intro: String,
    val movieInfoDto: List<MovieInfoDto>,
    val screenShots: String,
    val storyLine: String
){

    fun toMovieDetails(): MovieDetails{

        return MovieDetails(
            movieInfo = movieInfoDto.map { it.toMovieInfo() },
            extraInfo = extraInfoDto.map { it.toExtraInfo() }
        )
    }
}
package com.hfad.allmovie.domain.model.movie_details

data class MovieDetails(
    val extraInfo: List<ExtraInfo>?,
    val movieInfo: List<MovieInfo>?,
    val screenShots: String,
    val storyLine: String,
    val header: String

)

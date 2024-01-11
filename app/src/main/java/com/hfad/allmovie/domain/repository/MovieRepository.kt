package com.hfad.allmovie.domain.repository

import com.hfad.allmovie.data.remote.dto.allmovies_dto.AllMoviesDto
import com.hfad.allmovie.data.remote.dto.movie_details_dto.MovieDetailsDto
import com.hfad.allmovie.data.remote.dto.search_movie_dto.SearchMovieDto

interface MovieRepository {

    suspend fun getAllMovie(page: Int): AllMoviesDto

    suspend fun getMovieDetails(movieId: String): MovieDetailsDto

    suspend fun getMovieByName(name: String): List<SearchMovieDto>
}
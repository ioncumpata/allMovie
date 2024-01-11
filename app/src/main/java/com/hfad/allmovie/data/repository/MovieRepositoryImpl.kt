package com.hfad.allmovie.data.repository

import com.hfad.allmovie.data.remote.ApiMovies
import com.hfad.allmovie.data.remote.dto.allmovies_dto.AllMoviesDto
import com.hfad.allmovie.data.remote.dto.movie_details_dto.MovieDetailsDto
import com.hfad.allmovie.data.remote.dto.search_movie_dto.SearchMovieDto
import com.hfad.allmovie.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: ApiMovies
): MovieRepository {
    override suspend fun getAllMovie(page: Int): AllMoviesDto {
        return api.getAllMovies(page)
    }

    override suspend fun getMovieDetails(movieId: String): MovieDetailsDto {
        return api.getMovieDetails(movieId)
    }

    override suspend fun getMovieByName(name: String): List<SearchMovieDto> {
        return api.searchMovieByName(name)
    }
}
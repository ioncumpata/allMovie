package com.hfad.allmovie.domain.repository

import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.hfad.allmovie.data.local.entities.movies_entity.MoviesEntity
import com.hfad.allmovie.data.remote.dto.movie_details_dto.MovieDetailsDto
import com.hfad.allmovie.data.remote.dto.search_movie_dto.SearchMovieDto
import com.hfad.allmovie.domain.model.allmovies.Movie
import com.hfad.allmovie.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getMovieDetails(movieId: String): MovieDetailsDto

    suspend fun getMovieByName(name: String): List<SearchMovieDto>
}
package com.hfad.allmovie.domain.repository

import androidx.paging.PagingData
import com.hfad.allmovie.data.remote.dto.allmovies_dto.MovieDto
import com.hfad.allmovie.data.remote.dto.movie_details_dto.MovieDetailsDto
import com.hfad.allmovie.data.remote.dto.search_movie_dto.MainSearchDto
import kotlinx.coroutines.flow.Flow

interface MovieRepositoryRemote {

    suspend fun getMovies(): Flow<PagingData<MovieDto>>

    suspend fun getMovieDetails(movieId: String): MovieDetailsDto

    suspend fun getMovieByName(name: String): MainSearchDto
}
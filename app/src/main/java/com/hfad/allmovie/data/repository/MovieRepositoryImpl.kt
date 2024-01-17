package com.hfad.allmovie.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hfad.allmovie.data.local.MovieDataBase
import com.hfad.allmovie.data.paging.MoviesDataSource
import com.hfad.allmovie.data.remote.ApiMovies
import com.hfad.allmovie.data.remote.dto.allmovies_dto.MovieDto
import com.hfad.allmovie.data.remote.dto.movie_details_dto.MovieDetailsDto
import com.hfad.allmovie.data.remote.dto.search_movie_dto.SearchMovieDto
import com.hfad.allmovie.domain.repository.MovieRepository
import com.hfad.allmovie.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: ApiMovies,
) : MovieRepository {
    override suspend fun getMovies(): Flow<PagingData<MovieDto>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                MoviesDataSource(api = api)
            }
        ).flow
    }


    override suspend fun getMovieDetails(movieId: String): MovieDetailsDto {
        return api.getMovieDetails(movieId)
    }

    override suspend fun getMovieByName(name: String): List<SearchMovieDto> {
        return api.searchMovieByName(name)
    }
}
package com.hfad.allmovie.domain.use_cases

import androidx.paging.PagingData
import androidx.paging.map
import com.hfad.allmovie.data.remote.dto.allmovies_dto.MovieDto
import com.hfad.allmovie.domain.model.allmovies.Movie
import com.hfad.allmovie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AllMoviesUseCase(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(): Flow<PagingData<Movie>>{
        return repository.getMovies().map { pageData ->
            pageData.map { it.toMovie() }
        }
    }
}
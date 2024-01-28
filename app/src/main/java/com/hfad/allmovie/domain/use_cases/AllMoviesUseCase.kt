package com.hfad.allmovie.domain.use_cases

import androidx.paging.PagingData
import androidx.paging.map
import com.hfad.allmovie.domain.model.allmovies.Movie
import com.hfad.allmovie.domain.repository.MovieRepositoryRemote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AllMoviesUseCase(
    private val repository: MovieRepositoryRemote
) {
    suspend operator fun invoke(): Flow<PagingData<Movie>>{
        return repository.getMovies().map { pageData ->
            pageData.map { it.toMovie() }
        }
    }
}
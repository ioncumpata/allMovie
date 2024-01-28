package com.hfad.allmovie.domain.use_cases

import com.hfad.allmovie.domain.repository.MovieRepositoryLocal
import javax.inject.Inject

class IfExistInWatchListUseCase @Inject constructor(
    private val repositoryLocal: MovieRepositoryLocal
) {

    suspend operator fun invoke(movieId: String): Boolean {
        return repositoryLocal.ifExists(movieId)
    }
}
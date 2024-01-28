package com.hfad.allmovie.domain.use_cases

import com.hfad.allmovie.domain.repository.MovieRepositoryLocal
import javax.inject.Inject

class DeleteMovieFromWatchListUseCase @Inject constructor(
    private val repositoryLocal: MovieRepositoryLocal
) {

   suspend operator fun invoke(movieId: String) {
        return repositoryLocal.deleteOneFromMyList(movieId)
    }
}
package com.hfad.allmovie.domain.use_cases

import com.hfad.allmovie.data.local.toWatchListEntity
import com.hfad.allmovie.domain.model.watch_list.WatchListItem
import com.hfad.allmovie.domain.repository.MovieRepositoryLocal
import javax.inject.Inject

class AddMovieToWatchListUseCase @Inject constructor(
    private val repositoryLocal: MovieRepositoryLocal
) {

    suspend operator fun invoke(watchListItem: WatchListItem) {
        return repositoryLocal.addToMyList(watchListItem.toWatchListEntity())
    }

}
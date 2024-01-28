package com.hfad.allmovie.data.repository

import com.hfad.allmovie.data.local.MovieDataBase
import com.hfad.allmovie.data.local.WatchListEntity
import com.hfad.allmovie.domain.repository.MovieRepositoryLocal
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryLocalImpl @Inject constructor(
     movieDataBase: MovieDataBase

) : MovieRepositoryLocal {

    private val dao = movieDataBase.dao

    override fun getMyList(): List<WatchListEntity> {
        return dao.getMyList()
    }

    override suspend fun addToMyList(movie: WatchListEntity) {
        return dao.addToMyList(movie = movie)
    }

    override suspend fun ifExists(movieId: String): Boolean {
       return dao.ifExists(movieId)
    }

    override suspend fun deleteOneFromMyList(movieId: String) {
       return dao.deleteOneFromMyList(movieId)
    }
}
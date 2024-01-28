package com.hfad.allmovie.domain.repository

import com.hfad.allmovie.data.local.WatchListEntity
import kotlinx.coroutines.flow.Flow

interface MovieRepositoryLocal {

    fun getMyList(): List<WatchListEntity>

    suspend fun addToMyList(movie: WatchListEntity)

    suspend fun ifExists(movieId: String): Boolean

    suspend fun deleteOneFromMyList(movieId: String)
}
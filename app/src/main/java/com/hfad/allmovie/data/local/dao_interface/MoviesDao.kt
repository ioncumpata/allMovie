package com.hfad.allmovie.data.local.dao_interface

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.hfad.allmovie.data.local.entities.movies_entity.MoviesEntity

@Dao
interface MoviesDao {

    @Upsert
    suspend fun upsertAll(moviesEntity: MoviesEntity)

    @Query("SELECT * FROM moviesentity")
    fun pagingSource(): PagingSource<Int, MoviesEntity>

    @Query("DELETE FROM moviesentity")
    suspend fun clearAll()
}
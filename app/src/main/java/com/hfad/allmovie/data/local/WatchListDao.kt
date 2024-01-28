package com.hfad.allmovie.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hfad.allmovie.util.Resource
import kotlinx.coroutines.flow.Flow

@Dao
interface WatchListDao {

    @Query("SELECT * FROM WATCH_LIST ORDER BY id ASC")
    fun getMyList(): List<WatchListEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToMyList(movie: WatchListEntity)

    @Query("SELECT EXISTS (SELECT 1 FROM WATCH_LIST WHERE id = :movieId)")
    suspend fun ifExists(movieId: String) : Boolean

    @Query("DELETE FROM WATCH_LIST WHERE id =:movieId")
    suspend fun deleteOneFromMyList(movieId: String)
}
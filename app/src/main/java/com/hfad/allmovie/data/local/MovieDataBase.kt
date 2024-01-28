package com.hfad.allmovie.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [WatchListEntity::class],
    version = 1
)
abstract class MovieDataBase: RoomDatabase() {

    abstract val dao: WatchListDao
}
package com.hfad.allmovie.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hfad.allmovie.domain.model.watch_list.WatchListItem

@Entity(tableName = "WATCH_LIST")
data class WatchListEntity(
    @PrimaryKey
    val id: String,
    val img: String,
    val header: String
)

fun WatchListEntity.toWatchListItem(): WatchListItem{
    return WatchListItem(
        id = id,
        img = img,
        header = header
    )
}

fun WatchListItem.toWatchListEntity(): WatchListEntity{
    return WatchListEntity(
        id = id,
        img = img,
        header = header
    )
}
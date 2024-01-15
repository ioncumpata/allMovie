package com.hfad.allmovie.data.local.entities.movies_entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
 data class MoviesEntity(
 @PrimaryKey
  val id: String,
  val img: String,
  val text: String

 )
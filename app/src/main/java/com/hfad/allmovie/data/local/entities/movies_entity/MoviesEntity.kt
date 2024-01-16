package com.hfad.allmovie.data.local.entities.movies_entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hfad.allmovie.domain.model.allmovies.Movie

@Entity
 data class MoviesEntity(
 @PrimaryKey  val id: String,
  val img: String,
  val text: String

 ){

    fun toMovie(): Movie{
     return Movie(
      id = id,
      text = text,
      img = img
     )
    }

 }
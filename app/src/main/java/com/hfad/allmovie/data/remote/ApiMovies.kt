package com.hfad.allmovie.data.remote

import com.hfad.allmovie.data.remote.dto.allmovies_dto.AllMovieDto
import com.hfad.allmovie.data.remote.dto.movie_details_dto.MovieDetailsDto
import com.hfad.allmovie.data.remote.dto.search_movie_dto.MainSearchDto
import com.hfad.allmovie.data.remote.dto.search_movie_dto.SearchMovieDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiMovies {

    @Headers(
        "X-RapidAPI-Key: f3e937b351msh7645c07e5ecaa81p1ec214jsn4eaa57bdb635",
        "X-RapidAPI-Host: moviesverse1.p.rapidapi.com"
    )
    @GET("movies/{page}")
    suspend fun getAllMovies(@Path("page") page: Int): AllMovieDto

    @Headers(
        "X-RapidAPI-Key: f3e937b351msh7645c07e5ecaa81p1ec214jsn4eaa57bdb635",
        "X-RapidAPI-Host: moviesverse1.p.rapidapi.com"
    )
    @GET("movie/singleMovie/{movieId}")
    suspend fun getMovieDetails(@Path("movieId") movieId: String): MovieDetailsDto

    @Headers(
        "X-RapidAPI-Key: f3e937b351msh7645c07e5ecaa81p1ec214jsn4eaa57bdb635",
        "X-RapidAPI-Host: moviesverse1.p.rapidapi.com"
    )
    @GET("movies/movieBySearch/1")
    suspend fun searchMovieByName(@Query("search") name: String): MainSearchDto
}
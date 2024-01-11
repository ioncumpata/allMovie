package com.hfad.allmovie.domain.use_cases

import com.hfad.allmovie.domain.model.allmovies.AllMovies
import com.hfad.allmovie.domain.model.search_movie.SearchMovie
import com.hfad.allmovie.domain.repository.MovieRepository
import com.hfad.allmovie.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchMovieUseCase  @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(name: String): Flow<Resource<List<SearchMovie>>> = flow {
        try {

            emit(Resource.Loading())
            val movie = repository.getMovieByName(name).map { it.toSearchMovie() }
            emit(Resource.Success(movie))

        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))


        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))


        }
    }
}
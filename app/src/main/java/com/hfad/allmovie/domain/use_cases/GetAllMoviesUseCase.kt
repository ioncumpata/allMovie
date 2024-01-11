package com.hfad.allmovie.domain.use_cases

import com.hfad.allmovie.domain.model.allmovies.AllMovies
import com.hfad.allmovie.domain.repository.MovieRepository
import com.hfad.allmovie.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(page: Int): Flow<Resource<AllMovies>> = flow {
        try {

            emit(Resource.Loading())
            val movies = repository.getAllMovie(page).toAllMovies()
            emit(Resource.Success(movies))

        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))


        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))


        }
    }
}
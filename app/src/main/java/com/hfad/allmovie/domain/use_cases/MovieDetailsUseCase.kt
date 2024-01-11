package com.hfad.allmovie.domain.use_cases

import com.hfad.allmovie.domain.model.movie_details.MovieDetails
import com.hfad.allmovie.domain.repository.MovieRepository
import com.hfad.allmovie.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieDetailsUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(movieId: String): Flow<Resource<MovieDetails>> = flow {
        try {

            emit(Resource.Loading())
            val details = repository.getMovieDetails(movieId).toMovieDetails()
            emit(Resource.Success(details))

        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))


        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))


        }
    }
}
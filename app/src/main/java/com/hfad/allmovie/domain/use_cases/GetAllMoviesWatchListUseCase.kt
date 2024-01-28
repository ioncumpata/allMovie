package com.hfad.allmovie.domain.use_cases

import com.hfad.allmovie.data.local.toWatchListItem
import com.hfad.allmovie.domain.model.search_movie.SearchMovie
import com.hfad.allmovie.domain.model.watch_list.WatchListItem
import com.hfad.allmovie.domain.repository.MovieRepositoryLocal
import com.hfad.allmovie.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllMoviesWatchListUseCase @Inject constructor(
    private val repositoryLocal: MovieRepositoryLocal
) {

    operator fun invoke(): Flow<Resource<List<WatchListItem>>> = flow {
        try {

            emit(Resource.Loading())
            val movies = repositoryLocal.getMyList().map {  it.toWatchListItem() }
            emit(Resource.Success(movies))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))


        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))


        }
    }

}
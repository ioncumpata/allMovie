package com.hfad.allmovie.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hfad.allmovie.data.remote.ApiMovies
import com.hfad.allmovie.data.remote.dto.allmovies_dto.MovieDto
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MoviesDataSource @Inject constructor(
    private val api: ApiMovies
): PagingSource<Int, MovieDto>() {


    override fun getRefreshKey(state: PagingState<Int, MovieDto>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieDto> {
        return try {
            val nextPage = params.key ?: 1
            val movies = api.getAllMovies(nextPage)
            LoadResult.Page(
                data = movies.movies,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (movies.movies.isEmpty()) null else nextPage + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}

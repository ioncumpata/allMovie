package com.hfad.allmovie.data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hfad.allmovie.data.remote.ApiMovies
import com.hfad.allmovie.data.remote.dto.allmovies_dto.MovieDto
import com.hfad.allmovie.util.Constants.ITEMS_PER_PAGE
import javax.inject.Inject

class MoviesDataSource @Inject constructor(
    private val api: ApiMovies
): PagingSource<Int, MovieDto>() {

    override fun getRefreshKey(state: PagingState<Int, MovieDto>): Int? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieDto> {
        val pageIndex = params.key ?: 1
        return try {
            val page = params.key ?: 1
            val response = api.getAllMovies(page)
            Log.d("Prototype2", response.toString())
            LoadResult.Page(
                data = response,
                prevKey =  if (pageIndex == 0) null else pageIndex - 1,
                nextKey =  if (response.size == params.loadSize) pageIndex + (params.loadSize /  ITEMS_PER_PAGE) else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}

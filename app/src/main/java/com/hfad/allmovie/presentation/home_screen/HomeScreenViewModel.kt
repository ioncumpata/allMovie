package com.hfad.allmovie.presentation.home_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.hfad.allmovie.domain.model.allmovies.Movie
import com.hfad.allmovie.domain.model.watch_list.WatchListItem
import com.hfad.allmovie.domain.use_cases.AllMoviesUseCase
import com.hfad.allmovie.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {


    val moviesPage = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())

    private val ifExistState_ = mutableStateOf(false)
    val ifExistState: State<Boolean> = ifExistState_

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            moviesPage.value = useCases.allMoviesUseCase().cachedIn(viewModelScope)
        }
    }

    fun addMovieToWatchList(watchListItem: WatchListItem) {
        viewModelScope.launch {
            useCases.addMovieToWatchList(watchListItem)
        }
    }

    fun removeMovieFromWatchList(movieId: String) {
        viewModelScope.launch {
            useCases.deleteMovieFromWatchList(movieId)
        }
    }

    fun ifExistMovieInWatchList(movieId: String) {
        viewModelScope.launch {
            ifExistState_.value = useCases.ifExistInWatchList(movieId)
            Log.d("IfExist","${ifExistState.value}")
        }
    }


}

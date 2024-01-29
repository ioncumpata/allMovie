package com.hfad.allmovie.presentation.watchlist_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hfad.allmovie.domain.use_cases.UseCases
import com.hfad.allmovie.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WatchListViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _state = mutableStateOf(WatchListState())
    val state: State<WatchListState> = _state

    init {
        getMovieFromDb()
    }

    fun getMovieFromDb() = viewModelScope.launch(Dispatchers.IO) {

        delay(500)

        useCases.getAllMoviesWatchListUseCase().collect { result ->
            when (result) {
                is Resource.Success -> {

                    _state.value = WatchListState( movies = result.data)
                }
                is Resource.Error -> {
                    _state.value = WatchListState(
                        isError = result.message ?: "An error occur"
                    )

                }
                is Resource.Loading -> {
                    _state.value = WatchListState(isLoading = true)

                }
            }
        }
    }

    fun removeMovieFromWatchList(movieId: String) {
        viewModelScope.launch {
            useCases.deleteMovieFromWatchList(movieId)
        }
    }
}
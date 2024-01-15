package com.hfad.allmovie.presentation.home_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hfad.allmovie.domain.use_cases.GetAllMoviesUseCase
import com.hfad.allmovie.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getAllMoviesUseCase: GetAllMoviesUseCase
): ViewModel() {

    private val _state = mutableStateOf(AllMoviesState())
    val state: State<AllMoviesState> = _state


    init {

        getAllMovies(1)
    }


    private fun getAllMovies(page: Int) = viewModelScope.launch(Dispatchers.IO) {

        delay(500L)


        try {

            getAllMoviesUseCase(page).collect { result ->
                when (result) {
                    is Resource.Success -> {

                        _state.value = AllMoviesState(allMoviesList = result.data!!.movies)

                    }
                    is Resource.Error -> {
                        _state.value = AllMoviesState(
                            isError = result.message ?: "An error occur"
                        )

                    }
                    is Resource.Loading -> {
                        _state.value = AllMoviesState(isLoading = true)

                    }
                }
            }
        } catch (e: Exception) {
            _state.value = AllMoviesState(
                isLoading = false,
                allMoviesList = emptyList(),
                isError = "Error fetching weather"
            )
        }
    }

}
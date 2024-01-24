package com.hfad.allmovie.presentation.search_screen

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
class SearchViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _state = mutableStateOf(SearchMovieState())
    val state: State<SearchMovieState> = _state


    fun getMovie(nameMovie: String) = viewModelScope.launch(Dispatchers.IO) {


        delay(500L)


        useCases.searchMovieUseCase(nameMovie).collect { result ->
            when (result) {
                is Resource.Success -> {

                    _state.value = SearchMovieState(movies = result.data)
                }
                is Resource.Error -> {
                    _state.value = SearchMovieState(
                        isError = result.message ?: "An error occur"
                    )

                }
                is Resource.Loading -> {
                    _state.value = SearchMovieState(isLoading = true)

                }
            }
        }


    }
}
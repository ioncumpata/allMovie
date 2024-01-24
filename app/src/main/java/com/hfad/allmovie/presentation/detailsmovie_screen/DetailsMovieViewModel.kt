package com.hfad.allmovie.presentation.detailsmovie_screen

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
class DetailsMovieViewModel @Inject constructor(
    private val useCase: UseCases
): ViewModel() {

    private val _state = mutableStateOf(DetailsListState())
    val state: State<DetailsListState> = _state


    fun getMovieDetails(idMovie: String) = viewModelScope.launch(Dispatchers.IO) {


        delay(500L)


        useCase.movieDetailsUseCase(idMovie).collect { result ->
            when (result) {
                is Resource.Success -> {

                    _state.value = DetailsListState(movieDetails = result.data)
                }
                is Resource.Error -> {
                    _state.value = DetailsListState(
                        isError = result.message ?: "An error occur"
                    )

                }
                is Resource.Loading -> {
                    _state.value = DetailsListState(isLoading = true)

                }
            }
        }


    }



}
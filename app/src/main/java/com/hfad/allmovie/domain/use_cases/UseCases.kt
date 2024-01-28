package com.hfad.allmovie.domain.use_cases

class UseCases(
    val allMoviesUseCase: AllMoviesUseCase,
    val movieDetailsUseCase: MovieDetailsUseCase,
    val searchMovieUseCase: SearchMovieUseCase,
    val addMovieToWatchList: AddMovieToWatchListUseCase,
    val deleteMovieFromWatchList: DeleteMovieFromWatchListUseCase,
    val getAllMoviesWatchListUseCase: GetAllMoviesWatchListUseCase,
    val ifExistInWatchList: IfExistInWatchListUseCase
)
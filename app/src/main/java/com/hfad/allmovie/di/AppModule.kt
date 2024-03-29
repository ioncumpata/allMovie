package com.hfad.allmovie.di

import android.content.Context
import androidx.room.Room
import com.hfad.allmovie.data.local.MovieDataBase
import com.hfad.allmovie.data.remote.ApiMovies
import com.hfad.allmovie.data.repository.MovieRepositoryLocalImpl
import com.hfad.allmovie.data.repository.MovieRepositoryRemoteImpl
import com.hfad.allmovie.domain.repository.MovieRepositoryLocal
import com.hfad.allmovie.domain.repository.MovieRepositoryRemote
import com.hfad.allmovie.domain.use_cases.*
import com.hfad.allmovie.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    

    @Provides
    @Singleton
    fun providesHttpInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providesApiMovies(okHttpClient: OkHttpClient): ApiMovies {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiMovies::class.java)
    }

    @Provides
    @Singleton
    fun providesMovieRepositoryRemote(api: ApiMovies): MovieRepositoryRemote {
        return MovieRepositoryRemoteImpl(api)
    }

    @Provides
    @Singleton
    fun providesUseCases(
        repositoryRemote: MovieRepositoryRemote,
        repositoryLocal: MovieRepositoryLocal
    ): UseCases {
        return UseCases(
            allMoviesUseCase = AllMoviesUseCase(repositoryRemote),
            searchMovieUseCase = SearchMovieUseCase(repositoryRemote),
            movieDetailsUseCase = MovieDetailsUseCase(repositoryRemote),
            addMovieToWatchList = AddMovieToWatchListUseCase(repositoryLocal),
            getAllMoviesWatchListUseCase = GetAllMoviesWatchListUseCase(repositoryLocal),
            deleteMovieFromWatchList = DeleteMovieFromWatchListUseCase(repositoryLocal),
            ifExistInWatchList = IfExistInWatchListUseCase(repositoryLocal)
        )


    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MovieDataBase {
        return Room.databaseBuilder(
            context,
            MovieDataBase::class.java,
            "MOVIE_DATABASE"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMovieRepositoryLocal(movieDataBase: MovieDataBase): MovieRepositoryLocal {
        return MovieRepositoryLocalImpl(movieDataBase)
    }


}
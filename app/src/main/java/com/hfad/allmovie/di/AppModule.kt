package com.hfad.allmovie.di

import android.content.Context
import androidx.room.Room
import com.hfad.allmovie.data.local.MovieDataBase
import com.hfad.allmovie.data.remote.ApiMovies
import com.hfad.allmovie.data.repository.MovieRepositoryImpl
import com.hfad.allmovie.domain.repository.MovieRepository
import com.hfad.allmovie.domain.use_cases.AllMoviesUseCase
import com.hfad.allmovie.domain.use_cases.MovieDetailsUseCase
import com.hfad.allmovie.domain.use_cases.SearchMovieUseCase
import com.hfad.allmovie.domain.use_cases.UseCases
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
    fun provideMovieDatabase(@ApplicationContext context: Context): MovieDataBase {
        return Room.databaseBuilder(
            context,
            MovieDataBase::class.java,
            "movies.db"
        ).build()
    }

    @Provides
    @Singleton
    fun providesHttpInterceptor(): HttpLoggingInterceptor{
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient{
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
    fun providesMovieRepository(api: ApiMovies): MovieRepository {
        return MovieRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providesUseCases(repository: MovieRepository): UseCases {
        return UseCases(
            allMoviesUseCase = AllMoviesUseCase(repository),
            searchMovieUseCase = SearchMovieUseCase(repository),
            movieDetailsUseCase = MovieDetailsUseCase(repository)
        )


    }
}
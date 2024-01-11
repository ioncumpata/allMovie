package com.hfad.allmovie.di

import com.hfad.allmovie.data.remote.ApiMovies
import com.hfad.allmovie.data.repository.MovieRepositoryImpl
import com.hfad.allmovie.domain.repository.MovieRepository
import com.hfad.allmovie.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesApiMovies(): ApiMovies{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiMovies::class.java)
    }

    @Provides
    @Singleton
    fun providesMovieRepository(api: ApiMovies): MovieRepository {
        return MovieRepositoryImpl(api)
    }
}
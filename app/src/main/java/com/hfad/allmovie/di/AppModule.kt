package com.hfad.allmovie.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.hfad.allmovie.data.local.MovieDataBase
import com.hfad.allmovie.data.local.entities.movies_entity.MoviesEntity
import com.hfad.allmovie.data.remote.ApiMovies
import com.hfad.allmovie.data.repository.MovieRepositoryImpl
import com.hfad.allmovie.domain.repository.MovieRepository
import com.hfad.allmovie.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
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
    fun providesApiMovies(): ApiMovies{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiMovies::class.java)
    }

    @Provides
    @Singleton
    fun providesMovieRepository(api: ApiMovies, movieDb: MovieDataBase): MovieRepository {
        return MovieRepositoryImpl(api,movieDb)
    }


}
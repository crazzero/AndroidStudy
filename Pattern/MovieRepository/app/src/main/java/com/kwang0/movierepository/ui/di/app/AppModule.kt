package com.kwang0.movierepository.ui.di.app

import android.app.Application
import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import com.kwang0.movierepository.data.MoviesRepositoryImpl
import com.kwang0.movierepository.data.entity.mapper.EntityDataMapper
import com.kwang0.movierepository.data.executor.JobThread
import com.kwang0.movierepository.data.source.local.*
import com.kwang0.movierepository.data.source.remote.*
import com.kwang0.movierepository.domain.MoviesRepository
import com.kwang0.movierepository.domain.executor.JobScheduler
import com.kwang0.movierepository.domain.executor.UIScheduler
import com.kwang0.movierepository.ui.base.UIThread
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideSQLiteOpenHelper(context: Context): SQLiteOpenHelper {
        return MoviesDatabaseHelper(context)
    }

    @Provides
    @Singleton
    internal fun provideService(): MovieService {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieService::class.java)
    }

    @Provides
    @Singleton
    internal fun provideLocalDataSource(sqLiteOpenHelper: SQLiteOpenHelper): MoviesLocalDataSource {
        return MoviesLocalDataSourceImpl(sqLiteOpenHelper)
    }

    @Provides
    @Singleton
    internal fun provideRemoteDataSource(movieService: MovieService): MoviesRemoteDataSource {
        return MoviesRemoteDataSourceImpl(movieService)
    }

    @Provides
    @Singleton
    internal fun provideRepository(localDataSource: MoviesLocalDataSource,
                                   remoteDataSource: MoviesRemoteDataSource,
                                   entityDataMapper: EntityDataMapper
    ): MoviesRepository {
        return MoviesRepositoryImpl(localDataSource, remoteDataSource, entityDataMapper)
    }

    @Provides
    @Singleton
    internal fun provideUIScheduler(): UIScheduler {
        return UIThread()
    }

    @Provides
    @Singleton
    internal fun provideJobScheduler(): JobScheduler {
        return JobThread()
    }

}

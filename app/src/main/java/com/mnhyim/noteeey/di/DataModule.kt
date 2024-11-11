package com.mnhyim.noteeey.di

import android.content.Context
import androidx.room.Room
import com.mnhyim.noteeey.data.NoteeeyDatabase
import com.mnhyim.noteeey.data.dao.CategoryDao
import com.mnhyim.noteeey.data.repository.CategoryRepositoryImpl
import com.mnhyim.noteeey.domain.repository.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(
        @ApplicationContext context: Context,
    ): NoteeeyDatabase {
        return Room.databaseBuilder(
            context,
            NoteeeyDatabase::class.java,
            "noteey_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(database: NoteeeyDatabase) = database.categoryDao()

    @Provides
    @Singleton
    fun provideCategoryRepository(
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
        categoryDao: CategoryDao,
    ): CategoryRepository {
        return CategoryRepositoryImpl(
            ioDispatcher = ioDispatcher,
            categoryDao = categoryDao
        )
    }
}
package com.mnhyim.noteeey.di

import com.mnhyim.noteeey.domain.repository.CategoryRepository
import com.mnhyim.noteeey.domain.usecase.AddCategoryUseCase
import com.mnhyim.noteeey.domain.usecase.GetAllCategoriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideAddCategoryUseCase(
        categoryRepository: CategoryRepository
    ): AddCategoryUseCase {
        return AddCategoryUseCase(categoryRepository)
    }

    @Provides
    @Singleton
    fun provideGetAllCategoriesUseCase(
        categoryRepository: CategoryRepository
    ): GetAllCategoriesUseCase {
        return GetAllCategoriesUseCase(categoryRepository)
    }
}
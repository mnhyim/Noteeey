package com.mnhyim.noteeey.di

import com.mnhyim.noteeey.domain.repository.CategoryRepository
import com.mnhyim.noteeey.domain.repository.NoteRepository
import com.mnhyim.noteeey.domain.usecase.AddCategoryUseCase
import com.mnhyim.noteeey.domain.usecase.AddNoteUseCase
import com.mnhyim.noteeey.domain.usecase.DeleteCategoryUseCase
import com.mnhyim.noteeey.domain.usecase.GetAllCategoriesUseCase
import com.mnhyim.noteeey.domain.usecase.GetAllNotesUseCase
import com.mnhyim.noteeey.domain.usecase.UpdateCategoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetAllNotesUseCase(
        noteRepository: NoteRepository
    ): GetAllNotesUseCase {
        return GetAllNotesUseCase(noteRepository)
    }

    @Provides
    @Singleton
    fun provideAddNoteUseCase(
        noteRepository: NoteRepository
    ): AddNoteUseCase {
        return AddNoteUseCase(noteRepository)
    }

    @Provides
    @Singleton
    fun provideGetAllCategoriesUseCase(
        categoryRepository: CategoryRepository
    ): GetAllCategoriesUseCase {
        return GetAllCategoriesUseCase(categoryRepository)
    }

    @Provides
    @Singleton
    fun provideAddCategoryUseCase(
        categoryRepository: CategoryRepository
    ): AddCategoryUseCase {
        return AddCategoryUseCase(categoryRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateCategoryUseCase(
        categoryRepository: CategoryRepository
    ): UpdateCategoryUseCase {
        return UpdateCategoryUseCase(categoryRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteCategoryUseCase(
        categoryRepository: CategoryRepository
    ): DeleteCategoryUseCase {
        return DeleteCategoryUseCase(categoryRepository)
    }
}
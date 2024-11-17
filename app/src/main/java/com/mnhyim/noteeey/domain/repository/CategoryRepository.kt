package com.mnhyim.noteeey.domain.repository

import com.mnhyim.noteeey.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    fun getALlCategories(): Flow<List<Category>>
    fun getCategoryById(id: Long): Category
    suspend fun insertCategory(category: Category): Long
    suspend fun updateCategory(category: Category): Int
    suspend fun deleteCategory(category: Category): Int
}
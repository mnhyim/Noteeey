package com.mnhyim.noteeey.data.repository

import com.mnhyim.noteeey.data.dao.CategoryDao
import com.mnhyim.noteeey.data.entity.CategoryEntity
import com.mnhyim.noteeey.data.util.CategoryMapper
import com.mnhyim.noteeey.domain.model.Category
import com.mnhyim.noteeey.domain.repository.CategoryRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher,
    private val categoryDao: CategoryDao
) : CategoryRepository {

    override fun getALlCategories(): Flow<List<Category>> {
        return categoryDao.getAlLCategories().map { items ->
            items.map { item ->
                CategoryMapper.toModel(item)
            }
        }
    }

    override fun getCategoryById(id: Long): Category {
        TODO("Not yet implemented")
    }

    override suspend fun insertCategory(category: Category): Long {
        return withContext(ioDispatcher) {
            categoryDao.insertCategory(
                CategoryMapper.toEntity(category)
            )
        }
    }

    override suspend fun updateCategory(category: Category): Int {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCategory(category: Category): Int {
        TODO("Not yet implemented")
    }
}
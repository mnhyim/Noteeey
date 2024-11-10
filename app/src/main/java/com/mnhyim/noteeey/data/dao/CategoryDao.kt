package com.mnhyim.noteeey.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mnhyim.noteeey.data.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Query("SELECT * FROM categories")
    fun getAlLCategories(): Flow<List<CategoryEntity>>

    @Query("SELECT * FROM categories WHERE category_id = :id")
    fun getCategoryById(id: Long): CategoryEntity

    @Insert
    suspend fun insertCategory(category: CategoryEntity): Long

    @Update
    suspend fun updateCategory(category: CategoryEntity): Int

    @Delete
    suspend fun deleteCategory(category: CategoryEntity): Int
}
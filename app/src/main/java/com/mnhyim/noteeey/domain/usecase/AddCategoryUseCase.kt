package com.mnhyim.noteeey.domain.usecase

import android.util.Log
import com.mnhyim.noteeey.domain.model.Category
import com.mnhyim.noteeey.domain.repository.CategoryRepository
import java.time.LocalDateTime
import javax.inject.Inject

class AddCategoryUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {
    suspend operator fun invoke(name: String): Result<Unit> {
        val category = Category(
            id = 0,
            name = name,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )
        return try {
            categoryRepository.insertCategory(category)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
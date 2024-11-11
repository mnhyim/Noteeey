package com.mnhyim.noteeey.domain.usecase

import com.mnhyim.noteeey.domain.model.Category
import com.mnhyim.noteeey.domain.repository.CategoryRepository
import java.time.LocalDateTime
import javax.inject.Inject

class DeleteCategoryUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {
    suspend operator fun invoke(category: Category): Result<Unit> {
        return try {
            categoryRepository.deleteCategory(category)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
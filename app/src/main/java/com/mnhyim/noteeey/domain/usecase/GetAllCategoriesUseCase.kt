package com.mnhyim.noteeey.domain.usecase

import com.mnhyim.noteeey.domain.model.Category
import com.mnhyim.noteeey.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/* TODO: Should probably add Error Handling on this and the consumer ViewModels. */
class GetAllCategoriesUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {
    operator fun invoke(): Flow<List<Category>> {
        return categoryRepository.getALlCategories()
    }
}
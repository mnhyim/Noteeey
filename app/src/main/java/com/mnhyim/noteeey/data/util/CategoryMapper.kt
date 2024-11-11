package com.mnhyim.noteeey.data.util

import com.mnhyim.noteeey.data.entity.CategoryEntity
import com.mnhyim.noteeey.domain.model.Category
import java.time.LocalDateTime

object CategoryMapper {

    fun toEntity(category: Category): CategoryEntity {
        return CategoryEntity(
            id = category.id,
            name = category.name,
            createdAt = category.createdAt,
            updatedAt = category.updatedAt
        )
    }

    fun toModel(category: CategoryEntity): Category {
        return Category(
            id = category.id,
            name = category.name,
            createdAt = category.createdAt,
            updatedAt = category.updatedAt
        )
    }
}
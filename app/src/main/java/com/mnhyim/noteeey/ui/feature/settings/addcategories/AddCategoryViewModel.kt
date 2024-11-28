package com.mnhyim.noteeey.ui.feature.settings.addcategories

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnhyim.noteeey.domain.model.Category
import com.mnhyim.noteeey.domain.usecase.AddCategoryUseCase
import com.mnhyim.noteeey.domain.usecase.DeleteCategoryUseCase
import com.mnhyim.noteeey.domain.usecase.GetAllCategoriesUseCase
import com.mnhyim.noteeey.domain.usecase.UpdateCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddCategoryViewModel @Inject constructor(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val addCategoryUseCase: AddCategoryUseCase,
    private val updateCategoryUseCase: UpdateCategoryUseCase,
    private val deleteCategoryUseCase: DeleteCategoryUseCase
) : ViewModel() {

    private var _categories = MutableStateFlow(emptyList<Category>())
    val categories = _categories.asStateFlow()

    init {
        getCategories()
    }

    /* TODO: Should probably add Error Handling on this and the UseCase class. */
    private fun getCategories() {
        viewModelScope.launch {
            getAllCategoriesUseCase()
                .collect { categories ->
                    _categories.update { categories }
                }
        }
    }

    fun addCategory(value: String) {
        viewModelScope.launch {
            addCategoryUseCase(value)
                .onSuccess { }
                .onFailure { Log.d(this::class.simpleName, "Exception: ${it.localizedMessage}") }
        }
    }

    fun deleteCategory(category: Category) {
        viewModelScope.launch {
            deleteCategoryUseCase(category)
                .onSuccess { }
                .onFailure { Log.d(this::class.simpleName, "Exception: ${it.localizedMessage}") }
        }
    }
}
package com.mnhyim.noteeey.ui.feature.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnhyim.noteeey.domain.model.Category
import com.mnhyim.noteeey.domain.model.Note
import com.mnhyim.noteeey.domain.usecase.GetAllCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase
) : ViewModel() {

    private var _categories = MutableStateFlow<List<Category>>(emptyList())
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


    fun saveNote(
        title: String,
        note: String,
        categoryId: Long,
    ) {
        val tempNote = Note(
            id = 0,
            title = title,
            content = note,
            category = categories.value.first { it.id == categoryId },
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )
        viewModelScope.launch {

        }
    }
}
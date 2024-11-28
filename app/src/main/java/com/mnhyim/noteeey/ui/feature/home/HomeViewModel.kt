package com.mnhyim.noteeey.ui.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnhyim.noteeey.domain.model.Note
import com.mnhyim.noteeey.domain.usecase.GetAllNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase
) : ViewModel() {

    private var _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes = _notes.asStateFlow()

    init {
        getNotes()
    }

    private fun getNotes() {
        viewModelScope.launch {
            getAllNotesUseCase().collect { notes ->
                _notes.update { notes }
            }
        }
    }
}
package com.mnhyim.noteeey.ui.feature.addnote

sealed interface NoteEditorEvent {

    data class EditTitle(val title: String) : NoteEditorEvent
    data class SelectCategory(val categoryId: Long) : NoteEditorEvent
    data class SaveNote(val note: String)  : NoteEditorEvent
}
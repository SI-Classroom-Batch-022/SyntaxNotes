package de.syntax_institut.syntaxnotes.ui.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import de.syntax_institut.syntaxnotes.data.Note

class NoteListingViewModel : ViewModel() {

    private val _notes = MutableStateFlow(listOf<Note>())
    val notes = _notes.asStateFlow()

    private val _isShowingEditor = MutableStateFlow(false)
    val isShowingEditor = _isShowingEditor.asStateFlow()

    fun enableEditor() {
        _isShowingEditor.value = true
    }

    fun disableEditor() {
        _isShowingEditor.value = false
    }

    fun addNote(note: Note) {
        _notes.value += note
    }
}
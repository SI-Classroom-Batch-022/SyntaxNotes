package de.syntax_institut.syntaxnotes.ui.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import de.syntax_institut.syntaxnotes.data.Note
import de.syntax_institut.syntaxnotes.ui.NoteDisplayRoute

class NoteDisplayViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val parameters = savedStateHandle.toRoute<NoteDisplayRoute>()
    val note = Note(parameters.text)
}
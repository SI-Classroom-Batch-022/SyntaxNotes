package de.syntax_institut.syntaxnotes.ui.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NoteEditorViewModel : ViewModel() {

    private val _text = MutableStateFlow("")
    val text = _text.asStateFlow()

    private val _isCreateEnabled = MutableStateFlow(false)
    val isCreateEnabled = _isCreateEnabled.asStateFlow()

    fun updateText(newText: String) {
        _text.value = newText
        _isCreateEnabled.value = newText.isNotEmpty()
    }

    fun clearText() {
        updateText("")
    }
}
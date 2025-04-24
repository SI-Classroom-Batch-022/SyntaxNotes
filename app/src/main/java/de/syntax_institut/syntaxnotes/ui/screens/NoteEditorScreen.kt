package de.syntax_institut.syntaxnotes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import de.syntax_institut.syntaxnotes.data.Note
import de.syntax_institut.syntaxnotes.ui.viewmodels.NoteEditorViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteEditorScreen(
    onCloseClick: () -> Unit,
    onCreateNote: (Note) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: NoteEditorViewModel = viewModel()
) {
    val text by viewModel.text.collectAsState()
    val isCreateEnabled by viewModel.isCreateEnabled.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("New Note")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        viewModel.clearText()
                        onCloseClick()
                    }) {
                        Icon(Icons.Filled.Close, "Back")
                    }
                },
                actions = {
                    TextButton(
                        onClick = {
                            val note = Note(text)
                            onCreateNote(note)
                            viewModel.clearText()
                            onCloseClick()
                        },
                        enabled = isCreateEnabled
                    ) {
                        Text("Create")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(vertical = 24.dp, horizontal = 16.dp)
        ) {
            TextField(
                text,
                label = {
                    Text("Text")
                },
                onValueChange = viewModel::updateText,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteEditorScreenPreview() {
    NoteEditorScreen(
        onCloseClick = {},
        onCreateNote = { _ -> }
    )
}
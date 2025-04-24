package de.syntax_institut.syntaxnotes.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import de.syntax_institut.syntaxnotes.data.Note
import de.syntax_institut.syntaxnotes.ui.components.NoteListingRow
import de.syntax_institut.syntaxnotes.ui.viewmodels.NoteListingViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteListingScreen(
    onAddNewNoteClick: () -> Unit,
    onNoteClick: (Note) -> Unit,
    viewModel: NoteListingViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val notes by viewModel.notes.collectAsState()
    val isShowingEditor by viewModel.isShowingEditor.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("My Notes")
            })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = viewModel::enableEditor) {
                Icon(Icons.Filled.Add, "Add new note")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            items(notes) { note ->
                NoteListingRow(
                    note = note,
                    modifier = Modifier.clickable(
                        onClick = {
                            onNoteClick(note)
                        }
                    )
                )
            }
        }

        if (isShowingEditor) {
            ModalBottomSheet(onDismissRequest = viewModel::disableEditor) {
                NoteEditorScreen(onBackClick = viewModel::disableEditor)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteListingScreenPreview() {
    NoteListingScreen(
        onAddNewNoteClick = {},
        onNoteClick = { _ -> }
    )
}
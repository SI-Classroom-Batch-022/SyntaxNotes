package de.syntax_institut.syntaxnotes.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteListingScreen(
    onAddNewNoteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("My Notes")
            })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddNewNoteClick) {
                Icon(Icons.Filled.Add, "Add new note")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            // TODO: Dynamic listing of our notes.
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteListingScreenPreview() {
    NoteListingScreen(onAddNewNoteClick = {})
}
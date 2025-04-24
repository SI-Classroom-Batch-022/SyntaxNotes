package de.syntax_institut.syntaxnotes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import de.syntax_institut.syntaxnotes.data.Note
import de.syntax_institut.syntaxnotes.ui.viewmodels.NoteDisplayViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteDisplayScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: NoteDisplayViewModel = viewModel()
) {
    NoteDisplayScreenContent(
        onBackClick = onBackClick,
        note = viewModel.note,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NoteDisplayScreenContent(
    note: Note,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Note")
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(note.text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteDisplayScreenPreview() {
    NoteDisplayScreenContent(onBackClick = {}, note = Note("Example note."))
}
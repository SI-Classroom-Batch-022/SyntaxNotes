package de.syntax_institut.syntaxnotes.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.syntax_institut.syntaxnotes.data.Note

@Composable
fun NoteListingRow(note: Note, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = note.text,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun NoteListingRowPreview() {
    NoteListingRow(Note("Hello, Syntax!"))
}
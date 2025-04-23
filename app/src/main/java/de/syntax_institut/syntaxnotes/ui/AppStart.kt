package de.syntax_institut.syntaxnotes.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.syntax_institut.syntaxnotes.ui.screens.NoteEditorScreen
import de.syntax_institut.syntaxnotes.ui.screens.NoteListingScreen
import kotlinx.serialization.Serializable

@Serializable
object NoteListingRoute

@Serializable
object NoteEditorRoute

@Composable
fun AppStart() {
    val navController = rememberNavController()

    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NoteListingRoute,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable<NoteListingRoute> {
                NoteListingScreen(onAddNewNoteClick = {
                    navController.navigate(NoteEditorRoute)
                })
            }

            composable<NoteEditorRoute> {
                NoteEditorScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppStartPreview() {
    AppStart()
}
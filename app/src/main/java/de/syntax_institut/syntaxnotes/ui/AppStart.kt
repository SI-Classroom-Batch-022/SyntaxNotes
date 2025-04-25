package de.syntax_institut.syntaxnotes.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.syntax_institut.syntaxnotes.data.NoteDisplayRoute
import de.syntax_institut.syntaxnotes.data.NoteListingRoute
import de.syntax_institut.syntaxnotes.data.TabItem
import de.syntax_institut.syntaxnotes.ui.screens.NoteDisplayScreen
import de.syntax_institut.syntaxnotes.ui.screens.NoteListingScreen
import kotlinx.serialization.Serializable

@Composable
fun AppStart() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            TabBar()
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NoteListingRoute,
            modifier = Modifier.padding(innerPadding),
        ) {

            composable<NoteListingRoute> {
                NoteListingScreen(
                    onNoteClick = { note ->
                        navController.navigate(
                            NoteDisplayRoute(note.text)
                        )
                    },
                )
            }

            composable<NoteDisplayRoute> {
                NoteDisplayScreen(onBackClick = {
                    navController.popBackStack()
                })
            }
        }
    }
}

@Composable
private fun TabBar() {
    NavigationBar {
        TabItem.entries.forEach { tabItem ->
            NavigationBarItem(
                selected = false,
                onClick = {},
                icon = {
                    Icon(
                        imageVector = tabItem.tabIcon,
                        contentDescription = tabItem.tabTitle
                    )
                },
                label = {
                    Text(tabItem.tabTitle)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppStartPreview() {
    AppStart()
}
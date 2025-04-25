package de.syntax_institut.syntaxnotes.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.syntax_institut.syntaxnotes.data.NoteDisplayRoute
import de.syntax_institut.syntaxnotes.data.NoteFavoritesRoute
import de.syntax_institut.syntaxnotes.data.NoteListingRoute
import de.syntax_institut.syntaxnotes.data.SettingsRoute
import de.syntax_institut.syntaxnotes.data.TabItem
import de.syntax_institut.syntaxnotes.ui.screens.NoteDisplayScreen
import de.syntax_institut.syntaxnotes.ui.screens.NoteListingScreen

@Composable
fun AppStart() {

    val navController = rememberNavController()
    var selectedTabItem by rememberSaveable { mutableStateOf(TabItem.NOTE_LISTING) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                TabItem.entries.forEach { tabItem ->
                    NavigationBarItem(
                        selected = selectedTabItem == tabItem,
                        onClick = { selectedTabItem = tabItem },
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
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = selectedTabItem.route,
            modifier = Modifier.padding(innerPadding),
        ) {

            composable<NoteFavoritesRoute> {}

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

            composable<SettingsRoute> {}
        }
    }
}

@Composable
private fun TabBar() {
}

@Preview(showBackground = true)
@Composable
fun AppStartPreview() {
    AppStart()
}
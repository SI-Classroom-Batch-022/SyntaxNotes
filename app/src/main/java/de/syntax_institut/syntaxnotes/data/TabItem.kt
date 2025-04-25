package de.syntax_institut.syntaxnotes.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

enum class TabItem(
    val route: Any,
    val tabTitle: String,
    val tabIcon: ImageVector
) {
    NOTE_FAVORITES(NoteFavoritesRoute, "Favorites", Icons.Default.Star),
    NOTE_LISTING(NoteListingRoute, "Notes", Icons.AutoMirrored.Filled.List),
    SETTINGS(SettingsRoute, "Settings", Icons.Default.Settings)
}
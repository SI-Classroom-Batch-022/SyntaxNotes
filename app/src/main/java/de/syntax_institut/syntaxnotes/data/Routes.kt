package de.syntax_institut.syntaxnotes.data

import kotlinx.serialization.Serializable

@Serializable
object NoteFavoritesRoute

@Serializable
object NoteListingRoute

@Serializable
object SettingsRoute

@Serializable
data class NoteDisplayRoute(
    val text: String
)
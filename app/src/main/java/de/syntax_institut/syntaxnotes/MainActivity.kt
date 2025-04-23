package de.syntax_institut.syntaxnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import de.syntax_institut.syntaxnotes.ui.AppStart
import de.syntax_institut.syntaxnotes.ui.theme.SyntaxNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SyntaxNotesTheme {
                AppStart()
            }
        }
    }
}

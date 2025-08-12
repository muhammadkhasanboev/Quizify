package com.android.quizify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.android.quizify.ui.theme.QuizifyTheme

import io.appwrite.Client
import io.appwrite.services.Account
import io.appwrite.ID
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val client = Client(this)
            .setEndpoint("https://fra.cloud.appwrite.io/v1") // Your API Endpoint
            .setProject("689b02550012a40ac890") // Your project ID
            .setSelfSigned(true) // Remove in production
lifecycleScope.launch{
    val account = Account(client)
    val user = account.create(
        ID.unique(),
        "email@example.com",
        "password",
        "Walter O'Brien"
    )

}

        enableEdgeToEdge()
        setContent {
            QuizifyTheme {

            }
        }
    }
}


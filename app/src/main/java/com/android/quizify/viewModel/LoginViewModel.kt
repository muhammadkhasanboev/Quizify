package com.android.quizify.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import io.appwrite.Client
import io.appwrite.ID
import io.appwrite.models.*
import io.appwrite.services.*

class LoginViewModel(): ViewModel(){

    lateinit var client: Client
    lateinit var account: Account

    fun init(context: Context) {
        client = Client(context)
            .setEndpoint("https://fra.cloud.appwrite.io/v1")
            .setProject("689b02550012a40ac890")

        account = Account(client)
    }

    suspend fun onLogin(
        email: String,
        password: String,
    ): Session {
        return account.createEmailPasswordSession(
            email,
            password,
        )
    }

    suspend fun onRegister(
        email: String,
        password: String,
    ): User<Map<String, Any>> {
        return account.create(
            userId = ID.unique(),
            email,
            password,
        )
    }

    suspend fun onLogout() {
        account.deleteSession("current")
    }

}
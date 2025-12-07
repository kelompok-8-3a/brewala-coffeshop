package com.example.brewalacoffe.utils

import android.content.Context

class SessionManager(private val context: Context) {

    private val prefs = context.getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

    fun setLoginStatus(status: Boolean) {
        prefs.edit().putBoolean("IS_LOGGED_IN", status).apply()
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean("IS_LOGGED_IN", false)
    }

    fun logout() {
        prefs.edit().clear().apply()
    }
}

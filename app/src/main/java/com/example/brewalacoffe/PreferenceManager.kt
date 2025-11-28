package com.example.brewalacoffe

import android.content.Context

object PreferenceManager {
    private const val PREF_NAME = "get_started"
    private const val KEY_PREF_NAME = "first_open"

    fun isFirstOpen(context: Context): Boolean {
        val preferensi = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return preferensi.getBoolean(KEY_PREF_NAME, true)
    }

    fun setOpened(context: Context){
        val preferensi = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        preferensi.edit().putBoolean(KEY_PREF_NAME, false).apply()
    }
}
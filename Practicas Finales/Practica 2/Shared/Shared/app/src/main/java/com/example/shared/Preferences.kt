package com.example.shared

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class Preferences (context: Context) {
    private val prefsname = "com.example.shared"
    private val sharedname = "shared_name"
    private val prefs: SharedPreferences = context.getSharedPreferences(
        prefsname, MODE_PRIVATE
        )

    // Se crea la propiedad name que será persistente, además se modifica
    // su getter y setter para que almacene en SharedPreferences.
    var name: String
    get() = prefs.getString(sharedname, "").toString()
    set(value) = prefs.edit().putString(sharedname, value).apply()

    // Se eliminan las preferencias.
    fun deletePrefs() {
        prefs . edit ().apply {
            remove (sharedname)
            apply ()
        }
    }
}
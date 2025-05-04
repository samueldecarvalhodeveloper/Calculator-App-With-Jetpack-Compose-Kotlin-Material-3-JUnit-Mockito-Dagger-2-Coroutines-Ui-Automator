package com.example.calculatorapp.user_interface_theme_store

import android.content.Context
import com.example.calculatorapp.constants.THEME_KEY
import com.example.calculatorapp.infrastructure.anticorruption_layer.KeyValueDatabase
import com.example.calculatorapp.infrastructure.exceptions.NotExistingKeyException

class UserInterfaceThemeStore {
    companion object {
        suspend fun getNightModeThemeState(context: Context): Boolean {
            return try {
                KeyValueDatabase.getBooleanValue(THEME_KEY, context)
            } catch (_: NotExistingKeyException) {
                false
            }
        }

        suspend fun setNightModeThemeState(state: Boolean, context: Context) {
            KeyValueDatabase.setBooleanValue(THEME_KEY, state, context)
        }
    }
}
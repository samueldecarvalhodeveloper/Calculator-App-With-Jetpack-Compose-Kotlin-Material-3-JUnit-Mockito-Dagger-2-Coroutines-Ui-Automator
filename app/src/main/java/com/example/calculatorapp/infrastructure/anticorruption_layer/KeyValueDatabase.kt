package com.example.calculatorapp.infrastructure.anticorruption_layer

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.calculatorapp.constants.ApplicationConstants.Companion.APPLICATION_KEY_VALUE_DATABASE_NAME
import com.example.calculatorapp.infrastructure.exceptions.NotExistingKeyException
import com.example.calculatorapp.infrastructure.specifications.isRetrievedValueEqualToNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    APPLICATION_KEY_VALUE_DATABASE_NAME
)

class KeyValueDatabase {
    companion object {
        suspend fun getStringValue(key: String, context: Context): String {
            val preferencesOfKey = stringPreferencesKey(key)

            val retrievedValue =
                context.dataStore.data
                    .map { preferences -> preferences[preferencesOfKey] }
                    .first()

            if (isRetrievedValueEqualToNull(retrievedValue)) {
                throw NotExistingKeyException(key)
            }

            return retrievedValue as String
        }

        suspend fun getBooleanValue(key: String, context: Context): Boolean {
            val preferencesOfKey = booleanPreferencesKey(key)

            val retrievedValue =
                context.dataStore.data
                    .map { preferences -> preferences[preferencesOfKey] }
                    .first()

            if (isRetrievedValueEqualToNull(retrievedValue)) {
                throw NotExistingKeyException(key)
            }

            return retrievedValue as Boolean
        }

        suspend fun setBooleanValue(key: String, value: Boolean, context: Context) {
            val preferencesOfKey = booleanPreferencesKey(key)

            context.dataStore.edit { preferences ->
                preferences[preferencesOfKey] = value
            }
        }

        suspend fun setStringValue(key: String, value: String, context: Context) {
            val preferencesOfKey = stringPreferencesKey(key)

            context.dataStore.edit { preferences ->
                preferences[preferencesOfKey] = value
            }
        }
    }
}

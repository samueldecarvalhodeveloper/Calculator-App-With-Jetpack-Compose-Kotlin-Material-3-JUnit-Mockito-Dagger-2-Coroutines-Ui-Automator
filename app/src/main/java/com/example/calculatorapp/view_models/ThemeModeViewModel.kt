package com.example.calculatorapp.view_models

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculatorapp.user_interface_theme_store.UserInterfaceThemeStore
import kotlinx.coroutines.runBlocking

open class ThemeModeViewModel : ViewModel() {
    private var themeMode = MutableLiveData<Boolean>()

    open fun getThemeMode(context: Context): MutableLiveData<Boolean> {
        runBlocking {
            val storedTheme = UserInterfaceThemeStore.getNightModeThemeState(context)

            themeMode.value = storedTheme
        }

        return themeMode
    }

    open fun toggleTheme(context: Context) {
        runBlocking {
            themeMode.value = !(themeMode.value as Boolean)

            UserInterfaceThemeStore.setNightModeThemeState(themeMode.value as Boolean, context)
        }
    }
}
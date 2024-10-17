package com.example.calculatorapp.unitaries.user_interface_theme_store

import android.content.Context
import com.example.calculatorapp.user_interface_theme_store.UserInterfaceThemeStore
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class UserInterfaceThemeStoreTest {
    @Test
    fun testIfClassHandleThemeStoringOnKeyValueDatabase() {
        runBlocking {
            UserInterfaceThemeStore.setNightModeThemeState(true, context)

            val updatedThemeState = UserInterfaceThemeStore.getNightModeThemeState(context)

            assertTrue(updatedThemeState)
        }
    }

    companion object {
        val context: Context = mock(Context::class.java)

        @JvmStatic
        @BeforeClass
        fun beforeAll() {
            Mockito.`when`(context.applicationContext).thenReturn(context)
        }
    }
}
package com.example.calculatorapp.unitaries.user_interface_theme_store

import android.content.Context
import com.example.calculatorapp.user_interface_theme_store.UserInterfaceThemeStore
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

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
        lateinit var context: Context

        @JvmStatic
        @BeforeClass
        fun beforeAll() {
            context = mock(Context::class.java)

            `when`(context.applicationContext).thenReturn(context)
        }
    }
}
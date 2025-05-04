package com.example.calculatorapp.unitaries.user_interface_theme_store

import android.content.Context
import com.example.calculatorapp.user_interface_theme_store.UserInterfaceThemeStore
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import java.io.File

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
        private val context = mockk<Context>()
        private val databaseFileName = mockk<File>()

        @JvmStatic
        @BeforeClass
        fun beforeAll() {
            every { databaseFileName.path } returns ""

            every { context.applicationContext } returns context

            every { context.filesDir } returns databaseFileName
        }
    }
}
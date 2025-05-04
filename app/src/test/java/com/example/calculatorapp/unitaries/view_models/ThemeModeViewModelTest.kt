package com.example.calculatorapp.unitaries.view_models

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.calculatorapp.coroutine_rule.MainCoroutineRule
import com.example.calculatorapp.unitaries.user_interface_theme_store.UserInterfaceThemeStoreTest
import com.example.calculatorapp.view_models.ThemeModeViewModel
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertTrue
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import java.io.File

class ThemeModeViewModelTest {
    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Test
    fun testIfMethodGetThemeModeReturnsCurrentCalculationExpression() {
        every { themeModeViewModel.getThemeMode(context = context) } returns MutableLiveData(true)

        val themeState = themeModeViewModel.getThemeMode(context = context).value

        assertTrue(themeState!!)
    }

    @Test
    fun testIfMethodToggleThemeChangesThemeMode() {
        themeModeViewModel.toggleTheme(context)

        every { themeModeViewModel.getThemeMode(context = context) } returns MutableLiveData(true)

        val themeState = themeModeViewModel.getThemeMode(context = context).value

        assertTrue(themeState!!)
    }

    companion object {
        private val context = mockk<Context>()
        private val databaseFileName = mockk<File>()
        private val themeModeViewModel = mockk<ThemeModeViewModel>(relaxed = true)

        @JvmStatic
        @BeforeClass
        fun beforeAll() {
            every {databaseFileName.path } returns ""

            every {context.applicationContext } returns context

            every {context.filesDir } returns databaseFileName

            every {context.filesDir } returns databaseFileName
        }
    }
}

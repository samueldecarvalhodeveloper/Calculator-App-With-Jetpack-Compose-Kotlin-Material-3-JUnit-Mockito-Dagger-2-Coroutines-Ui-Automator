package com.example.calculatorapp.unitaries.view_models

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.calculatorapp.coroutine_rule.MainCoroutineRule
import com.example.calculatorapp.view_models.ThemeModeViewModel
import org.junit.Assert.assertTrue
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class ThemeModeViewModelTest {
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Test
    fun testIfMethodGetThemeModeReturnsCurrentCalculationExpression() {
        val themeState = themeModeViewModel.getThemeMode(context = context).value

        assertTrue(themeState!!)
    }

    @Test
    fun testIfMethodToggleThemeChangesThemeMode() {
        themeModeViewModel.toggleTheme(context)

        val themeState = themeModeViewModel.getThemeMode(context = context).value

        assertTrue(themeState!!)
    }

    companion object {
        lateinit var context: Context
        lateinit var themeModeViewModel: ThemeModeViewModel

        @JvmStatic
        @BeforeClass
        fun beforeAll() {
            context = mock(Context::class.java)
            themeModeViewModel = mock(ThemeModeViewModel::class.java)

            `when`(themeModeViewModel.getThemeMode(context = context)).thenReturn(
                MutableLiveData(true)
            )
        }
    }
}

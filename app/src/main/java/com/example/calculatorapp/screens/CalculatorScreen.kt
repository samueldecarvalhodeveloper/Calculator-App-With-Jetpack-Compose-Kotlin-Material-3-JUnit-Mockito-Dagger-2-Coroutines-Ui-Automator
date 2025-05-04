package com.example.calculatorapp.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.calculatorapp.R
import com.example.calculatorapp.components.action_bar.ActionBar
import com.example.calculatorapp.components.button.Button
import com.example.calculatorapp.components.keyboard.Keyboard
import com.example.calculatorapp.components.viewfinder.Viewfinder
import com.example.calculatorapp.constants.VIEWFINDER_VALUE_WIDTH
import com.example.calculatorapp.domains.calculator.CalculatorCharacters
import com.example.calculatorapp.theme.Theme
import com.example.calculatorapp.user_interface_calculator_characters.UserInterfaceCalculatorCharacters
import com.example.calculatorapp.view_models.CalculatorViewModel
import com.example.calculatorapp.view_models.ThemeModeViewModel

@Composable
fun CalculatorScreen(
    calculatorViewModel: CalculatorViewModel,
    themeModeViewModel: ThemeModeViewModel
) {
    val context = LocalContext.current

    val calculationExpression = calculatorViewModel
        .getCalculationExpression(context = context)
        .observeAsState()
        .value as String
    val themeMode = themeModeViewModel
        .getThemeMode(context = context)
        .observeAsState()
        .value as Boolean

    val viewFinderScrollState = ScrollState(VIEWFINDER_VALUE_WIDTH(calculationExpression.length))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Theme.colors.appBackgroundColor)
    ) {
        ActionBar(
            actionIconDrawableResourceId = if (themeMode) R.drawable.moon_waning_crescent
            else R.drawable.white_balance_sunny,
            actionContentDescriptionStringResourceId = R.string.actionbar_menu_toggle_night_mode_content_description,
        ) {
            themeModeViewModel.toggleTheme(context)
        }
        Viewfinder(calculationExpression, viewFinderScrollState)
        Keyboard {
            Row(
                modifier = Modifier
                    .weight(weight = 1f, fill = true)
                    .padding(bottom = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                        .padding(end = 8.dp)
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.CLEAN,
                        backgroundColor = Theme.colors.yellowButtonBackgroundColor,
                        characterColor = Theme.colors.yellowButtonCharacterColor,
                        borderColor = Theme.colors.yellowButtonBorderColor,
                    ) {
                        calculatorViewModel.clean(context)
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                        .padding(end = 8.dp)
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.DIVISION,
                        backgroundColor = Theme.colors.secondaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.secondaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.secondaryBlueButtonBorderColor,
                    ) {
                        calculatorViewModel.addCharacter(CalculatorCharacters.DIVISION, context)
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                        .padding(end = 8.dp)
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.MULTIPLICATION,
                        backgroundColor = Theme.colors.secondaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.secondaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.secondaryBlueButtonBorderColor,
                    ) {
                        calculatorViewModel.addCharacter(
                            CalculatorCharacters.MULTIPLICATION,
                            context
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.BACKSPACE,
                        backgroundColor = Theme.colors.yellowButtonBackgroundColor,
                        characterColor = Theme.colors.yellowButtonCharacterColor,
                        borderColor = Theme.colors.yellowButtonBorderColor,
                    ) {
                        calculatorViewModel.backspace(context)
                    }
                }
            }
            Row(
                modifier = Modifier
                    .weight(weight = 1f, fill = true)
                    .padding(bottom = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                        .padding(end = 8.dp)
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.SEVEN,
                        backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.primaryBlueButtonBorderColor,
                    ) {
                        calculatorViewModel.addCharacter(CalculatorCharacters.SEVEN, context)
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                        .padding(end = 8.dp)
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.EIGHT,
                        backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.primaryBlueButtonBorderColor,
                    ) {
                        calculatorViewModel.addCharacter(CalculatorCharacters.EIGHT, context)
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                        .padding(end = 8.dp)
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.NINE,
                        backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.primaryBlueButtonBorderColor,
                    ) {
                        calculatorViewModel.addCharacter(CalculatorCharacters.NINE, context)
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.SUBTRACTION,
                        backgroundColor = Theme.colors.secondaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.secondaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.secondaryBlueButtonBorderColor,
                    ) {
                        calculatorViewModel.addCharacter(CalculatorCharacters.SUBTRACTION, context)
                    }
                }
            }
            Row(
                modifier = Modifier
                    .weight(weight = 1f, fill = true)
                    .padding(bottom = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                        .padding(end = 8.dp)
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.FOUR,
                        backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.primaryBlueButtonBorderColor,
                    ) {
                        calculatorViewModel.addCharacter(CalculatorCharacters.FOUR, context)
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                        .padding(end = 8.dp)
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.FIVE,
                        backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.primaryBlueButtonBorderColor,
                    ) {
                        calculatorViewModel.addCharacter(CalculatorCharacters.FIVE, context)
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                        .padding(end = 8.dp)
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.SIX,
                        backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.primaryBlueButtonBorderColor,
                    ) {
                        calculatorViewModel.addCharacter(CalculatorCharacters.SIX, context)
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.ADDITION,
                        backgroundColor = Theme.colors.secondaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.secondaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.secondaryBlueButtonBorderColor,
                    ) {
                        calculatorViewModel.addCharacter(CalculatorCharacters.ADDITION, context)
                    }
                }
            }
            Row(
                modifier = Modifier
                    .weight(weight = 2f, fill = true)
                    .padding(bottom = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .weight(weight = 3f, fill = true)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(weight = 1f, fill = true)
                            .padding(bottom = 8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(weight = 1f, fill = true)
                                .padding(end = 8.dp)
                        ) {
                            Button(
                                character = UserInterfaceCalculatorCharacters.ONE,
                                backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                                characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                                borderColor = Theme.colors.primaryBlueButtonBorderColor,
                            ) {
                                calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context)
                            }
                        }
                        Box(
                            modifier = Modifier
                                .weight(weight = 1f, fill = true)
                                .padding(end = 8.dp)
                        ) {
                            Button(
                                character = UserInterfaceCalculatorCharacters.TWO,
                                backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                                characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                                borderColor = Theme.colors.primaryBlueButtonBorderColor,
                            ) {
                                calculatorViewModel.addCharacter(CalculatorCharacters.TWO, context)
                            }
                        }
                        Box(
                            modifier = Modifier
                                .weight(weight = 1f, fill = true)
                        ) {
                            Button(
                                character = UserInterfaceCalculatorCharacters.THREE,
                                backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                                characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                                borderColor = Theme.colors.primaryBlueButtonBorderColor,
                            ) {
                                calculatorViewModel.addCharacter(
                                    CalculatorCharacters.THREE,
                                    context
                                )
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(weight = 1f, fill = true)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(weight = 2f, fill = true)
                                .padding(end = 8.dp)
                        ) {
                            Button(
                                character = UserInterfaceCalculatorCharacters.ZERO,
                                backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                                characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                                borderColor = Theme.colors.primaryBlueButtonBorderColor,
                            ) {
                                calculatorViewModel.addCharacter(CalculatorCharacters.ZERO, context)
                            }
                        }
                        Box(
                            modifier = Modifier
                                .weight(weight = 1f, fill = true)
                        ) {
                            Button(
                                character = UserInterfaceCalculatorCharacters.POINT,
                                backgroundColor = Theme.colors.secondaryBlueButtonBackgroundColor,
                                characterColor = Theme.colors.secondaryBlueButtonCharacterColor,
                                borderColor = Theme.colors.secondaryBlueButtonBorderColor,
                            ) {
                                calculatorViewModel.addCharacter(
                                    CalculatorCharacters.POINT,
                                    context
                                )
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(weight = 1f, fill = true)
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.EVALUATION,
                        backgroundColor = Theme.colors.yellowButtonBackgroundColor,
                        characterColor = Theme.colors.yellowButtonCharacterColor,
                        borderColor = Theme.colors.yellowButtonBorderColor,
                    ) {
                        calculatorViewModel.evaluate(context)
                    }
                }
            }
        }
    }
}

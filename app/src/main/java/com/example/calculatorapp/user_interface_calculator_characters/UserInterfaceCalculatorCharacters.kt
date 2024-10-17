package com.example.calculatorapp.user_interface_calculator_characters

import com.example.calculatorapp.domains.calculator.CalculatorCharacters


enum class UserInterfaceCalculatorCharacters(val value: String) {
    ZERO(CalculatorCharacters.ZERO.value),

    ONE(CalculatorCharacters.ONE.value),

    TWO(CalculatorCharacters.TWO.value),

    THREE(CalculatorCharacters.THREE.value),

    FOUR(CalculatorCharacters.FOUR.value),

    FIVE(CalculatorCharacters.FIVE.value),

    SIX(CalculatorCharacters.SIX.value),

    SEVEN(CalculatorCharacters.SEVEN.value),

    EIGHT(CalculatorCharacters.EIGHT.value),

    NINE(CalculatorCharacters.NINE.value),

    ADDITION(CalculatorCharacters.ADDITION.value),

    SUBTRACTION(CalculatorCharacters.SUBTRACTION.value),

    DIVISION(CalculatorCharacters.DIVISION.value),

    MULTIPLICATION(CalculatorCharacters.MULTIPLICATION.value),

    POINT(CalculatorCharacters.POINT.value),

    CLEAN("C"),

    EVALUATION("="),

    BACKSPACE("<")
}
package com.example.calculatorapp.constants

class StringUtilitiesConstants {
    companion object {
        const val EMPTY_STRING = ""

        const val STRING_FIRST_INDEX = 0

        fun STRING_LAST_INDEX(string: String): Int {
            return string.length - 1
        }
    }
}

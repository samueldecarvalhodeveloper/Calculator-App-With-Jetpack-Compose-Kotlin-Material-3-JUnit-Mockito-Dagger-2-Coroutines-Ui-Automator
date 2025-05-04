package com.example.calculatorapp.infrastructure.exceptions

import com.example.calculatorapp.constants.NOT_EXISTING_KEY_EXCEPTION_MESSAGE

class NotExistingKeyException(key: String) : Exception(
    NOT_EXISTING_KEY_EXCEPTION_MESSAGE(
        key
    )
)

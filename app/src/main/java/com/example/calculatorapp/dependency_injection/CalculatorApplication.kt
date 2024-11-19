package com.example.calculatorapp.dependency_injection

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CalculatorApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CalculatorApplication)
            modules(applicationModule)
        }
    }
}

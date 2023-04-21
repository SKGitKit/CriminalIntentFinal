package com.khanappsnj.criminalintentfinal

import android.app.Application
import com.khanappsnj.criminalintentfinal.database.CrimeRepository

class CriminalIntentApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}
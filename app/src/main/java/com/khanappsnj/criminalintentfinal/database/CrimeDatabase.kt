package com.khanappsnj.criminalintentfinal.database

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.khanappsnj.criminalintentfinal.Crime

    @Database(entities = [Crime :: class],version = 1)
    @TypeConverters(CrimeTypeConverters::class)
    abstract class CrimeDatabase : RoomDatabase(){
            abstract fun crimeDao(): CrimeDao
    }





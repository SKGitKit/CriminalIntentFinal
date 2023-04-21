package com.khanappsnj.criminalintentfinal

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khanappsnj.criminalintentfinal.database.CrimeRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

private const val TAG = "CrimeListViewModel"

class CrimeListViewModel : ViewModel() {
    private val crimeRepository = CrimeRepository.get()
    private val _crimes: MutableStateFlow<kotlin.collections.List<Crime>> = MutableStateFlow(
        emptyList()
    )
    val crimes :  StateFlow<List<Crime>>
            get() = _crimes.asStateFlow()

    init {
        viewModelScope.launch() {
            crimeRepository.getCrimes().collect(){
                _crimes.value = it
            }
        }
    }

}


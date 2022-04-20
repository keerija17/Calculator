package com.example.calculator.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    val average = MutableLiveData<Float>()
    init {
        Log.i("MainActivityViewModel", "MainActivityViewModel created")
        average.value = 0.00f
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("MainActivityViewModel", "MainActivityViewModel cleared")

    }
    fun calculateAverage(num1: Float, num2: Float):Float{
        average.value = ((num1 + num2)/2)
        return average.value ?:.00f
    }
}
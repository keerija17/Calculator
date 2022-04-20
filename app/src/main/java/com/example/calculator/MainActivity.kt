package com.example.calculator

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.calculator.ViewModel.MainActivityViewModel
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.btnCalcAverage.setOnClickListener{
            val num1 = binding.txtNum1.text.toString().toFloat()
            val num2 = binding.txtNum2.text.toString().toFloat()
            val average = mainActivityViewModel.calculateAverage(num1, num2)
        }
        mainActivityViewModel.average.observe(this,Observer{ newAverage ->
            binding.txtResult.text = "The average is $newAverage"})
    }

}
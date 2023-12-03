package com.mvvm.mvvm_sum_divide_multiply_subtraction_kotlin.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.mvvm.mvvm_sum_divide_multiply_subtraction_kotlin.model.CalculatorData

class CalculatorViewModel:ViewModel() {

    fun calculateSum(initialNumber:Double, secondNumber:Double):CalculatorData{
        val sum = initialNumber+secondNumber
        return  CalculatorData(initialNumber,secondNumber,sum)

    }
    fun calculateMultiply(initialNumber:Double, secondNumber:Double):CalculatorData{
        val multiply = initialNumber*secondNumber
        return  CalculatorData(initialNumber,secondNumber,multiply)

    }

    fun calculateSubtraction(initialNumber:Double, secondNumber:Double):CalculatorData{
        val subtraction = initialNumber-secondNumber
        return  CalculatorData(initialNumber,secondNumber,subtraction)

    }

    fun calculateDivision(initialNumber:Double, secondNumber:Double):CalculatorData{
        if (secondNumber == 0.0) {
            Log.d("Dividing error", "Division by zero")
            return CalculatorData(initialNumber, secondNumber, Double.NaN) // Use NaN to indicate an error
        }
        val dived = initialNumber/secondNumber
        return  CalculatorData(initialNumber,secondNumber,dived)

    }

}
package com.mvvm.mvvm_sum_divide_multiply_subtraction_kotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import com.mvvm.mvvm_sum_divide_multiply_subtraction_kotlin.R
import com.mvvm.mvvm_sum_divide_multiply_subtraction_kotlin.databinding.ActivityMainBinding
import com.mvvm.mvvm_sum_divide_multiply_subtraction_kotlin.viewmodel.CalculatorViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CalculatorViewModel

    private lateinit var numOne: EditText
    private lateinit var numTwo: EditText
    private lateinit var equalSign: ImageView
    private  var opreationSign="+"
    // todo result page

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel= ViewModelProvider(this)[CalculatorViewModel::class.java]
        initValues()
        binding.equals.setOnClickListener{
            val num1= binding.initialNumber.text.toString().toDoubleOrNull()?:0
            val num2= binding.secondNumber.text.toString().toDoubleOrNull()?:0
            if(opreationSign=="+")
            {
                val result = viewModel.calculateSum(num1.toDouble(),num2.toDouble())
                binding.result.text=result.result.toString()

            }
            if(opreationSign=="-")
            {
                val result = viewModel.calculateSubtraction(num1.toDouble(),num2.toDouble())
                binding.result.text=result.result.toString()


            }
            if(opreationSign=="x")
            {
                val result = viewModel.calculateMultiply(num1.toDouble(),num2.toDouble())
                binding.result.text=result.result.toString()


            }
            if(opreationSign=="/")
            {
                val result = viewModel.calculateDivision(num1.toDouble(),num2.toDouble())
                binding.result.text=result.result.toString()


            }

        }

        // get values from data
    }

    private fun initValues() {
//
        binding.plus.setOnClickListener {
            setTextForOps("+")
            opreationSign="+"
        }
        binding.minus.setOnClickListener {
            setTextForOps("-")
            opreationSign="-"

        }
        binding.multiply.setOnClickListener {
            setTextForOps("x")
            opreationSign="x"

        }
        binding.divied.setOnClickListener {
            setTextForOps("/")
            opreationSign="/"
        }




    }

    private fun setTextForOps(ops:String)
    {
        binding.operation.text=ops
    }
}
package com.example.kalkulator

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kalkulator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var display = ""
    private var input1 = "";
    private var input2 = "";
    private var result = 0;
    private var operator = "";
    private val operators = arrayOf("+", "-", "*", "/")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btn0.setOnClickListener {
            input2 += "0"
            display += "0"
            binding.tvInput.text = display
        }
        binding.btn1.setOnClickListener {
            input2 += "1"
            display += "1"
            binding.tvInput.text = display
        }
        binding.btn2.setOnClickListener {
            input2 += "2"
            display += "2"
            binding.tvInput.text = display
        }
        binding.btn3.setOnClickListener {
            input2 += "3"
            display += "3"
            binding.tvInput.text = display
        }
        binding.btn4.setOnClickListener {
            input2 += "4"
            display += "4"
            binding.tvInput.text = display
        }
        binding.btn5.setOnClickListener {
            input2 += "5"
            display += "5"
            binding.tvInput.text = display
        }
        binding.btn6.setOnClickListener {
            input2 += "6"
            display += "6"
            binding.tvInput.text = display
        }
        binding.btn7.setOnClickListener {
            input2 += "7"
            display += "7"
            binding.tvInput.text = display
        }
        binding.btn8.setOnClickListener {
            input2 += "8"
            display += "8"
            binding.tvInput.text = display
        }
        binding.btn9.setOnClickListener {
            input2 += "9"
            display += "9"
            binding.tvInput.text = display
        }

        binding.btnPlus.setOnClickListener {
            operatorHandler(binding.btnPlus)
        }
        binding.btnMinus.setOnClickListener {
            operatorHandler(binding.btnMinus)
        }
        binding.btnMultiply.setOnClickListener {
            operatorHandler(binding.btnMultiply)
        }
        binding.btnDivide.setOnClickListener {
            operatorHandler(binding.btnDivide)
        }

        binding.btnClear.setOnClickListener {
            input1 = ""
            input2 = ""
            display = ""
            operator = ""
            result = 0
            binding.tvInput.text = "0"
            binding.tvResult.text = "0"
        }
        binding.btnEqual.setOnClickListener {
            calculate()
            operator = "="
        }
        binding.btnDel.setOnClickListener {
            if (input2 != "" && operators.indexOf(display.last().toString()) == -1) {
                input2 = input2.dropLast(1)
                display = display.dropLast(1)
                binding.tvInput.text = display
            }
        }
    }

    private fun operatorHandler(button: Button) {
        if (display != "" && operators.indexOf(display.last().toString()) != -1) {
            display = display.dropLast(1)
        } else if (input1 == "") {
            input1 = input2
            input2 = ""
        } else if (input2 != "") {
            calculate()
        }

        operator = button.text.toString()
        display += operator
        binding.tvInput.text = display
    }

    private fun calculate() {
        if (operator == "=") {
            return
        }
        when (operator) {
            "+" -> {
                result = input1.toInt() + input2.toInt()
            }

            "-" -> {
                result = input1.toInt() - input2.toInt()
            }

            "*" -> {
                result = input1.toInt() * input2.toInt()
            }

            "/" -> {
                result = input1.toInt() / input2.toInt()
            }
        }

        input1 = result.toString()
        input2 = ""
        binding.tvResult.text = result.toString()
        Toast.makeText(this, "Result: $result", Toast.LENGTH_SHORT).show()
    }
}
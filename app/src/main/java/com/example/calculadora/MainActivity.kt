package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding  //se declara
    var firsValue: Double = 0.0
    var operator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater) //se inicializa

        val view = binding.root //llama a Linearlayout
        setContentView(view)
        binding.botBorrar.setOnClickListener {
            //Toast.makeText(this,"test",Toast.LENGTH_LONG).show()
            binding.edteCalculadora.setText(binding.edteCalculadora.text.dropLast(1))
        }

        binding.botLimpiar.setOnClickListener {
            //binding.edte_calculadora.setText((binding.edte_calculadora.text.clear()))
            binding.edteCalculadora.text.clear()
        }

        binding.resul.setOnClickListener {
            when(operator){
                "Multiplicacion" ->{
                    binding.edteCalculadora.setText("${firsValue * binding.edteCalculadora.text.toString().toDouble()}")
                }
                "Division" -> {
                    binding.edteCalculadora.setText("${firsValue / binding.edteCalculadora.text.toString().toDouble()}")
                }
                "Resta" -> {
                    binding.edteCalculadora.setText("${firsValue - binding.edteCalculadora.text.toString().toDouble()}")
                }
                "Suma" -> {
                    binding.edteCalculadora.setText("${firsValue + binding.edteCalculadora.text.toString().toDouble()}")
                }
            }
        }

        binding.botPorciento.setOnClickListener {
            binding.edteCalculadora.setText("${binding.edteCalculadora.text.toString().toDouble() / 100}")
        }

    }

    fun presionoBoton (view: View){
        val button = view as Button

        when(button.id){
            //Agrega condicional para decimal
            binding.punto.id -> {
                if (!binding.edteCalculadora.text.contains('.')) {
                    binding.edteCalculadora.text.append(".")
                }
            }
            binding.num0.id -> { binding.edteCalculadora.text.append("0")}
            binding.num1.id -> { binding.edteCalculadora.text.append("1")}
            binding.num2.id -> { binding.edteCalculadora.text.append("2")}
            binding.num3.id -> { binding.edteCalculadora.text.append("3")}
            binding.num4.id -> { binding.edteCalculadora.text.append("4")}
            binding.num5.id -> { binding.edteCalculadora.text.append("5")}
            binding.num6.id -> { binding.edteCalculadora.text.append("6")}
            binding.num7.id -> { binding.edteCalculadora.text.append("7")}
            binding.num8.id -> { binding.edteCalculadora.text.append("8")}
            binding.num9.id -> { binding.edteCalculadora.text.append("9")}
            else -> {Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show() }
        }

    }

    fun operatorClicked(view: View){
        val button = view as Button

        operator = when(button.id){
            binding.botMultiplicar.id ->{"Multiplicacion"}
            binding.botDividir.id ->{"Division"}
            binding.botSumar.id ->{"Suma"}
            binding.botRestar.id ->{"Resta"}

            else ->{ "" }
        }

        firsValue = binding.edteCalculadora.text.toString().toDouble()

        binding.edteCalculadora.text.clear()

    }
}
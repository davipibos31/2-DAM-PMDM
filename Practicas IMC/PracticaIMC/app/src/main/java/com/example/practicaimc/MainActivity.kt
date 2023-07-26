package com.example.practicaimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //event button click
        bcalcular.setOnClickListener {
            //Comprobamos si estan seleccionados los radiobutton y sino que salte un mensaje
            if(radioGroup.checkedRadioButtonId < 0) {
                Toast.makeText(applicationContext,R.string.sexo, Toast.LENGTH_SHORT).show()
            } else {
                //busca el id del radiobutton y ejecuta la funcion actionbutton por el text del radiobutton seleccionado
                val sexoRB = findViewById<View>(radioGroup.checkedRadioButtonId) as RadioButton
                actionbutton(sexoRB.text as String)
            }
        }
    }
    private fun  actionbutton(button:String) {
        when(button) {

            // dos opciones hombre/mujer y cada una es igual cambiando las caracteristicas
            // comprobamos si los campos de altura y peso estan rellenos sino salta mensaje
            "Hombre"->
                if ((editTextTextPersonName.text.isEmpty() || editTextTextPersonName2.text.isEmpty())) {
                    Toast.makeText(applicationContext,R.string.vacio,Toast.LENGTH_SHORT).show()
                } else {
                    // convertimos en numero flotante con dos decimales y realizamos el calculo del IMC
                    val altura = editTextTextPersonName.text.toString().toDouble() / 100
                    val peso = editTextTextPersonName2.text.toString().toDouble()
                    val imc = peso / (altura * altura)
                    // Realizamos las comprobaciones si es sobrepeso, obesidad, normal o inferior a normal con sentencias if else
                    resultado.text = String.format("%.2f", imc)
                    if (imc > 30.0) {
                        categoria.text = getString(R.string.Obesidad)
                    } else if (imc in 25.0..29.9) {
                        categoria.text = getString(R.string.sobrepeso)
                    }  else if (imc in 18.5..24.9) {
                        categoria.text = getString(R.string.Normal)
                    } else if (imc < 18.5) {
                        categoria.text = getString(R.string.inferior)
                    }
                }
            "Mujer" -> // comprobamos si los campos de altura y peso estan rellenos sino salta mensaje
                if ((editTextTextPersonName.text.isEmpty() || editTextTextPersonName2.text.isEmpty())) {
                    Toast.makeText(applicationContext,R.string.vacio,Toast.LENGTH_SHORT).show()
                } else {
                    // convertimos en numero flotante con dos decimales y realizamos el calculo del IMC
                    val altura = editTextTextPersonName.text.toString().toDouble() / 100
                    val peso = editTextTextPersonName2.text.toString().toDouble()
                    val imc = peso / (altura * altura)
                    // Realizamos las comprobaciones si es sobrepeso, obesidad, normal o inferior a normal con sentencias if else
                    resultado.text = String.format("%.2f", imc)
                    if (imc > 29.0) {
                        categoria.text = getString(R.string.Obesidad)
                    } else if (imc in 25.0..28.9) {
                        categoria.text = getString(R.string.sobrepeso)
                    }  else if (imc in 18.5..23.9) {
                        categoria.text = getString(R.string.Normal)
                    } else if (imc < 18.5) {
                        categoria.text = getString(R.string.inferior)
                    }
                }
        }
    }
}
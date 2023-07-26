@file:Suppress("unused")

package com.example.practicaimc2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.example.practicaimc2.person.Persons
import com.example.practicaimc2.person.IPersonsDataSource
import com.example.practicaimc2.adapters.PersonsAdapterList
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("PrivatePropertyName")
class MainActivity : AppCompatActivity() {
    private lateinit var PersonsFileDataSource : IPersonsDataSource
    private lateinit var listPersons: List<Persons>
    private lateinit var adapter : PersonsAdapterList
    companion object {
        var altura: Double = 0.0
        var peso: Double = 0.0
        var imc : Double = 0.0
        var cat :String = ""
        var sexo : String = ""
    }
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
        camventlisten()
    }
    private fun actionbutton(button:String) {
        when(button) {

            // dos opciones hombre/mujer y cada una es igual cambiando las caracteristicas
            // comprobamos si los campos de altura y peso estan rellenos sino salta mensaje
            "Hombre"->
                if ((editTextTextPersonName.text.isEmpty() || editTextTextPersonName2.text.isEmpty())) {
                    Toast.makeText(applicationContext,R.string.vacio,Toast.LENGTH_SHORT).show()
                } else {
                    // convertimos en numero flotante con dos decimales y realizamos el calculo del IMC
                    altura = editTextTextPersonName.text.toString().toDouble() / 100
                    peso = editTextTextPersonName2.text.toString().toDouble()
                    imc = peso / (altura * altura)
                    sexo = "Hombre"
                    // Realizamos las comprobaciones si es sobrepeso, obesidad, normal o inferior a normal con sentencias if else
                    resultado.text = String.format("%.2f", imc)
                    if (imc > 30.0) {
                        categoria.text = getString(R.string.Obesidad)
                        cat = "obesidad"
                    } else if (imc in 25.0..29.9) {
                        categoria.text = getString(R.string.sobrepeso)
                        cat = "sobrepeso"
                    }  else if (imc in 18.5..24.9) {
                        categoria.text = getString(R.string.Normal)
                        cat = "normal"
                    } else if (imc < 18.5) {
                        categoria.text = getString(R.string.inferior)
                        cat = "peso inferior al normal"
                    }
                }
            "Mujer" -> // comprobamos si los campos de altura y peso estan rellenos sino salta mensaje
                if ((editTextTextPersonName.text.isEmpty() || editTextTextPersonName2.text.isEmpty())) {
                    Toast.makeText(applicationContext,R.string.vacio,Toast.LENGTH_SHORT).show()
                } else {
                    // convertimos en numero flotante con dos decimales y realizamos el calculo del IMC
                    altura = editTextTextPersonName.text.toString().toDouble() / 100
                    peso = editTextTextPersonName2.text.toString().toDouble()
                    imc = peso / (altura * altura)
                    sexo = "Mujer"
                    // Realizamos las comprobaciones si es sobrepeso, obesidad, normal o inferior a normal con sentencias if else
                    resultado.text = String.format("%.2f", imc)
                    if (imc > 29.0) {
                        categoria.text = getString(R.string.Obesidad)
                        cat = "obesidad"
                    } else if (imc in 25.0..28.9) {
                        categoria.text = getString(R.string.sobrepeso)
                        cat = "sobrepeso"
                    }  else if (imc in 18.5..23.9) {
                        categoria.text = getString(R.string.Normal)
                        cat = "normal"
                    } else if (imc < 18.5) {
                        categoria.text = getString(R.string.inferior)
                        cat = "peso inferior al normal"
                    }
                }
        }
    }

    private fun camventlisten() {

        bfichero.setOnClickListener{
            val myIntent = Intent(this, SecondActivity::class.java)
            startActivity(myIntent)

        }
    }
}
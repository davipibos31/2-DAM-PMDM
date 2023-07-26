@file:Suppress("unused")

package com.example.practicaimc4.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.practicaimc4.R
import androidx.appcompat.app.AlertDialog
import com.example.practicaimc4.person.Persons
import com.example.practicaimc4.person.IPersonsDataSource
import com.example.practicaimc4.adapters.PersonsAdapterList
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_a.*
import kotlinx.android.synthetic.main.fragment_a.view.*
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("ControlFlowWithEmptyBody", "PrivatePropertyName")
class FragmentA : Fragment() {
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
    private var name : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            name = it?.getString("name")
        }
    }

    @Suppress("unused")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        root_layout2.bcalcular.setOnClickListener {
            //Comprobamos si estan seleccionados los radiobutton y sino que salte un mensaje
            if(root_layout2.radioGroup.checkedRadioButtonId < 0) {
                Snackbar.make(root_layout2, getString(R.string.sexo), Snackbar.LENGTH_LONG).show()
            } else {
                //busca el id del radiobutton y ejecuta la funcion actionbutton por el text del radiobutton seleccionado
                if (root_layout2.Hombre.isChecked)
                    actionbutton(root_layout2.Hombre.text as String)
                else if (root_layout2.Mujer.isChecked)
                    actionbutton(root_layout2.Mujer.text as String)
                makeDialog()
            }
        }
        root_layout2.bfichero.setOnClickListener{
            if (root_layout2.Hombre.isChecked)
                Snackbar.make(root_layout2, "Altura: " + root_layout2.editTextTextPersonName.text + "Peso: " + root_layout2.editTextTextPersonName2.text + "Sexo: " + root_layout2.Hombre.text + "IMC: " + root_layout2.resultado.text + "Categoria: " + root_layout2.categoria.text, Snackbar.LENGTH_LONG).show()
            else if (root_layout2.Mujer.isChecked)
                Snackbar.make(root_layout2, "Altura: " + root_layout2.editTextTextPersonName.text + "Peso: " + root_layout2.editTextTextPersonName2.text + "Sexo: " + root_layout2.Mujer.text + "IMC: " + root_layout2.resultado.text + "Categoria: " + root_layout2.categoria.text, Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    private fun makeDialog() {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.apply {
            setTitle(getString(R.string.Pruebas))
            setMessage(getString(R.string.mensaje1))
            setPositiveButton(getString(R.string.dialog_button_positivo)) {_,_->
                Snackbar.make(root_layout2, getString(R.string.positivo), Snackbar.LENGTH_LONG).show()
            }
            setNegativeButton(getString(R.string.dialog_button_negativo)) {_,_->
                Snackbar.make(root_layout2, getString(R.string.negativo), Snackbar.LENGTH_LONG).show()
            }
            alertDialog.show()
        }
    }

    private fun actionbutton(button:String) {
        when(button) {

            // dos opciones hombre/mujer y cada una es igual cambiando las caracteristicas
            // comprobamos si los campos de altura y peso estan rellenos sino salta mensaje
            "Hombre"->
                if ((editTextTextPersonName.text.isEmpty() || editTextTextPersonName2.text.isEmpty())) {
                    Snackbar.make(root_layout2, getString(R.string.vacio), Snackbar.LENGTH_LONG).show()
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
                    Snackbar.make(root_layout2, getString(R.string.vacio), Snackbar.LENGTH_LONG).show()
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
}
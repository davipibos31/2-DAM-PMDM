package com.example.ejercicio232

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var baceptar:Button
    lateinit var  bhola:RadioButton
    lateinit var badios:RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViews()

        bhola.setOnCheckedChangeListener { compoundButton, b -> saludar() }
        badios.setOnCheckedChangeListener { compoundButton, b ->  saludar()}
        baceptar.setOnClickListener { aceptar() }

    }
    private fun findViews(){
        bhola = findViewById(R.id.radioButton)
        badios=findViewById(R.id.radioButton2)
        baceptar=findViewById(R.id.button)
    }
    private fun aceptar(){

        var tunombre:EditText = findViewById(R.id.editTextTextPersonName)
        if(tunombre.text.toString().isEmpty()){
            Toast.makeText(this,getString(R.string.vacio),Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this,getString(R.string.saludo,tunombre.text),Toast.LENGTH_SHORT).show()
        }
    }

    private fun saludar(){

        var tunombre:EditText=findViewById(R.id.editTextTextPersonName)

        if(bhola.isChecked){
            Toast.makeText(this,getString(R.string.saludo,tunombre.text),Toast.LENGTH_SHORT).show()
        }
        else if(badios.isChecked){
            Toast.makeText(this,getString(R.string.adios,tunombre.text),Toast.LENGTH_SHORT).show()
        }
    }
}
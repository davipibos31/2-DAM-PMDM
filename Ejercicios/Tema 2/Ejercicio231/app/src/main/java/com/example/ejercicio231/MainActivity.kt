package com.example.ejercicio231


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var botonaceptar:Button
    lateinit var  botonhola:RadioButton
    lateinit var botonadios:RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViews()

        botonhola.setOnCheckedChangeListener { compoundButton, b -> saludar() }
        botonadios.setOnCheckedChangeListener { compoundButton, b ->  saludar()}
        botonaceptar.setOnClickListener { aceptar() }

    }
    private fun findViews(){
        botonhola = findViewById(R.id.radioButton)
        botonadios=findViewById(R.id.radioButton2)
        botonaceptar=findViewById(R.id.button)
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

        if(botonhola.isChecked){
            Toast.makeText(this,getString(R.string.saludo,tunombre.text),Toast.LENGTH_SHORT).show()
        }
        else if(botonadios.isChecked){
            Toast.makeText(this,getString(R.string.adios,tunombre.text),Toast.LENGTH_SHORT).show()
        }
    }
}
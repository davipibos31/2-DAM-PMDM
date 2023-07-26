package com.example.practica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonAceptar:Button=findViewById(R.id.button)

        botonAceptar.setOnClickListener{registro()}
    }

private fun registro(){

   val nombreUsuario:EditText=findViewById(R.id.editTextTextPassword)
 if(nombreUsuario.text.toString().isEmpty()){
            Toast.makeText(
                this,R.string.usuariovacio,
                Toast.LENGTH_SHORT

            ).show()
 }

    else if(nombreUsuario.text.toString().equals("ricardo")){
        Toast.makeText(
            this,R.string.usuariocorrecto,
            Toast.LENGTH_SHORT

        ).show()
 }
    else if(!nombreUsuario.text.toString().equals("ricardo")){
        Toast.makeText(
            this,R.string.usuarioincorrecto,
            Toast.LENGTH_SHORT
        ).show()

    }

    val contraseña:EditText=findViewById(R.id.editTextNumberPassword)
    if(contraseña.text.toString().isEmpty()){
        Toast.makeText(
            this,R.string.contraseñavacia,
            Toast.LENGTH_SHORT

        ).show()
    }

    else if(contraseña.text.toString().equals("1234")){
        Toast.makeText(
            this,R.string.contraseñacorrecta,
            Toast.LENGTH_SHORT

        ).show()
    }
    else if(!contraseña.text.toString().equals("1234")){
        Toast.makeText(
            this,R.string.contraseñaincorrecta,
            Toast.LENGTH_SHORT
        ).show()

    }
}
}
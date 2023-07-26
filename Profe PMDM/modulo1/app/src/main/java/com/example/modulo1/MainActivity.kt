package com.example.modulo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonHola: Button = findViewById(R.id.btHello)
        botonHola.setOnClickListener { sayHello() }
    }

    private fun sayHello() {
        val etTuNombre: EditText = findViewById(R.id.etYourName)
        if (etTuNombre.text.toString().isEmpty()) {
            Toast.makeText(this, R.string.msgNeedName, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, getString(R.string.msgSaludo, etTuNombre.text), Toast.LENGTH_SHORT).show()
        }
    }

}
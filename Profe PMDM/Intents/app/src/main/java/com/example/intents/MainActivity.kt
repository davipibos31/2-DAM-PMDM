package com.example.intents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MESSAGE = "mymessage"
        const val EXTRA_NOMBRE = "rtydytre"
        const val EXTRA_APELLIDO = "drfdfy"
        private var REQUEST_CODE = 1234
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListener()
    }

    private fun setListener() {
        btnIntent.setOnClickListener {
            val myIntent = Intent(this, SecondActivity::class.java).apply {
                // Se añade la información a pasar por clave-valor.
                putExtra("mymessageesgfdsgdf", textView.text.toString())
                putExtra(EXTRA_NOMBRE, "este es el valor de nombre")
                putExtra(EXTRA_APELLIDO, "este es al valor de apellido")

            }
            // Se lanza la activity.
            // startActivity(myIntent)
            startActivityForResult(myIntent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, data?.getStringExtra("EXTRA_RESULT"), Toast.LENGTH_LONG).show()
                //binding.tvResult.text = "Condiciones aceptadas."

            } else if (resultCode == Activity.RESULT_CANCELED) {
                //binding.tvResult.text = "Se canceló el contrato!"
                Toast.makeText(this, "Se canceló el contrato!", Toast.LENGTH_LONG).show()


            }
        }
    }
}
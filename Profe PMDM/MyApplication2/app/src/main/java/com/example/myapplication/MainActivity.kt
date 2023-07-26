package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //var txtName: TextView = findViewById(R.id.txtName)
        button.setOnClickListener {
            actionButtons("toast")
        }
        buttonToast.setOnClickListener {
            actionButtons("snackbar")
        }
    }

    private fun actionButtons(pepe: String) {
        when (pepe) {
            "button1" -> {
                checkBox.isChecked = !checkBox.isChecked

                if (radioButton1.isChecked) {
                    radioButton2.isChecked = true
                } else {
                    radioButton1.isChecked = true
                }
                toggleButton.isChecked = !toggleButton.isChecked
                switch1.isChecked = !switch1.isChecked
            }
            "toast" -> {
                var message: String = ""
                if (!editTextTextPersonName.text.isEmpty()) {
                    message += "Esto es del editeText ${editTextTextPersonName.text}."
                }
                message += "Esto es del TextView ${textView.text}."
                Toast.makeText(applicationContext, "Holaaa $message", Toast.LENGTH_LONG).show()
            }
            "snackbar" -> {
                Snackbar.make(root_main, "snackbar", Snackbar.LENGTH_LONG)
                    .setAction("Aceptar") {
                        textView.text = "Has presionado al snackbar"
                    }
                    .show()
            }
        }
    }
}
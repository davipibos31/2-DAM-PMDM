package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(){
            actionbutton("button")
        }
        switch1.setOnClickListener(){
            actionbutton("snackbar")
        }
    }
    private fun actionbutton(button: String) {
        when(button) {
            "button" ->
                if (editTextTextPersonName.text.isEmpty()) {
                    Toast.makeText(applicationContext, "esta vacio", Toast.LENGTH_SHORT).show()
                }
                else {
                    switch1.isChecked = false
                    Toast.makeText(applicationContext, "${editTextTextPersonName.text}", Toast.LENGTH_SHORT).show()
                }
            "snackbar" ->
                if (switch1.isChecked) {
                    Snackbar.make(root_main, "${editTextTextPersonName.text}", Snackbar.LENGTH_SHORT).show()
                }
        }
    }

}
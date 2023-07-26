package com.example.ejercicio461


import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       button.setOnClickListener() {
            actionButton("button")
        }
    }

    private fun actionButton(button: String) {

        var tunombre: EditText = findViewById(R.id.editTextTextPersonName)

        if(tunombre.text.toString().isEmpty()){
            Toast.makeText(this, getString(R.string.vacio), Toast.LENGTH_SHORT).show()
        }
        else if (!switch1.isChecked) {
            Toast.makeText(this,tunombre.text, Toast.LENGTH_SHORT).show()
        }
        else if (switch1.isChecked) {
            Snackbar.make(
                root_layout,
                tunombre.text,
                Snackbar.LENGTH_LONG
            ).show()
        }
    }
}
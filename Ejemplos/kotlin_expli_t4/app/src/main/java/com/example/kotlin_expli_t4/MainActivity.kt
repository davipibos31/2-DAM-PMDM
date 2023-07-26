package com.example.kotlin_expli_t4

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


       button.setOnClickListener(){
           actionButton("button1")

       }
        button3.setOnClickListener {

        actionButton("snackbar")
        }
    }

    private fun actionButton(button:String){
        when(button){
            "button1"->{
                if(radioButton.isChecked){
                    radioButton2.isChecked=true
                }
                else{
                    radioButton.isChecked=true
                }
                checkBox.isChecked=true

                switch1.isChecked=true
            }
            "button2"->{
                var message: String=""
                if(!linea.text.isEmpty()){
                    message+=" hola edittext  ${linea.text}"
                }
                message+="esto es del texview ${txtname.text}"
                Toast.makeText(applicationContext,"hola ${message}", Toast.LENGTH_SHORT).show()
            }

            "snackbar"->{
               Snackbar.make(root_main,"snckbar", Snackbar.LENGTH_SHORT).setAction("aceptar")

                   {linea.text="comete un garron de la gran flauta"}

                   ).show()
            }




        }
    }
}
package com.example.ejercicio51

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.second_activity.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val Extra_Message = "myMessage"
    }
    private lateinit var binding: SecondActivity
    var esValido = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListener()
    }

    private fun setListener() {
        btnEnviar.setOnClickListener() {
            val myIntent = Intent(this, SecondActivity::class.java)
            startActivity(myIntent)
            if (TextUtils.isEmpty(binding.textView.text.toString())) {
                binding.textView.error = "Informacion requerida"
                esValido = false
            } else binding.textView.error = null
        }
    }
}
package com.example.intents

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.intents.MainActivity.Companion.EXTRA_APELLIDO
import com.example.intents.MainActivity.Companion.EXTRA_MESSAGE
import com.example.intents.MainActivity.Companion.EXTRA_NOMBRE
import kotlinx.android.synthetic.main.activity_second.*
import com.example.intents.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initView()
        setListener()
    }

    private fun initView() {
        val nombre = intent.getStringExtra(EXTRA_NOMBRE)
        val message = intent.getStringExtra("mymessage")
        val apellido = intent.getStringExtra(EXTRA_APELLIDO)
        txtView.text = nombre
    }

    private fun setListener() {
        button.setOnClickListener {
            val intentResult: Intent = Intent().apply {
                putExtra("EXTRA_RESULT", editText.text.toString())
            }
            setResult(Activity.RESULT_OK, intentResult)
            finish()

        }

        button2.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}
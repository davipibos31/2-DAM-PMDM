package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListener()
    }

    fun setListener() {
        button.setOnClickListener {
            Snackbar.make(mid_layout, "", Snackbar.LENGTH_LONG).show()
            Toast.makeText(this, "", Toast.LENGTH_LONG).show()
        }
    }
}
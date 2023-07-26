package com.example.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Switch
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    lateinit var btn: Button
    lateinit var rbtnYes: RadioButton
    lateinit var rbtnNo: RadioButton
    lateinit var switch1: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint)
        findViews()
        setListeners()
        setViews()
    }

    private fun setViews() {
        setButtonState(false)
    }

    private fun findViews() {
        btn = findViewById(R.id.btnMainOk)
        rbtnYes = findViewById(R.id.radioButtonYes)
        rbtnNo = findViewById(R.id.radioButtonNo)
        switch1 = findViewById(R.id.switch1)

    }

    private fun setListeners() {
        btn.setOnClickListener {
            sayHello()
        }
        switch1.setOnCheckedChangeListener { compoundButton, b ->
            setButtonState(b)
        }
    }

    private fun setButtonState(b: Boolean) {
        btn.isEnabled = b
    }

    private fun sayHello() {
        var btn: Button = findViewById(R.id.btnMainOk)
        if (rbtnYes.isChecked) {
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
        } else if (rbtnNo.isChecked) {
            Toast.makeText(this, "Bye", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Nothing", Toast.LENGTH_SHORT).show()
        }
    }
}
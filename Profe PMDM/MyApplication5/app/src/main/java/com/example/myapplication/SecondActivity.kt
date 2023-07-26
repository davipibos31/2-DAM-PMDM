package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.MainActivity.Companion.AGE_MESSAGE
import com.example.myapplication.MainActivity.Companion.LASTNAME_MESSAGE
import com.example.myapplication.MainActivity.Companion.NAME_MESSAGE
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    companion object {
        var RETURN_MESSAGE = "name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initView()
        setListener()
    }

    private fun initView() {
        val name = intent.getStringExtra(NAME_MESSAGE)
        val lastName = intent.getStringExtra(LASTNAME_MESSAGE)
        val age = intent.getIntExtra(AGE_MESSAGE, 0)

    }

    private fun setListener() {
        btnReturn.setOnClickListener {
            //setResult(RESULT_CANCELED)
            val intentResult = Intent()
            intentResult.putExtra(RETURN_MESSAGE, "esto es el resultado de second")
            setResult(RESULT_OK, intentResult)
            finish()
        }
    }
}
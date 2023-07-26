package com.example.dialogs

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.dialog_login.*
import kotlinx.coroutines.*
import java.lang.Runnable
import java.time.Month
import java.time.Year
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var  myAsyncTask: MyAsyncTask
    private var job : Job? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListener()
    }
    private fun setListener() {

        btnAlert.setOnClickListener {
            makeDialog()
        }
        btnAlertSingleList.setOnClickListener {
            makeDialogSingleList()
        }
        btnAlertSingleChoice.setOnClickListener {
            makeDialogSingleChoice()
        }
        btnAlertMultiChoice.setOnClickListener {
            makeDialogMultiChoice()
        }
        btnCustomAlert.setOnClickListener {
            makeCustomDialog()
        }
        btnDataPicker.setOnClickListener {
            makeDataPicker()
        }
        btnTimePicker.setOnClickListener {
            makeTimePicker()
        }
        btnProgressBar.setOnClickListener {
            myAsyncTask = MyAsyncTask(
                this,
                progressBar,
                btnProgressBar,
                btnProgressBarCancel
                )
            myAsyncTask.execute(100,1000)
        }
        btnProgressBarCancel.setOnClickListener {
         myAsyncTask?.cancel(true)
        }

        btnCorrutinaProgressBar.setOnClickListener {
            job = makeTask(15,
                btnCorrutinaProgressBar,
                btnCorrutinaProgressBarCancel,
                Corrutina_progressBar
            )
        }
        btnCorrutinaProgressBarCancel.setOnClickListener {
            job.let {
                job?.cancel().apply {
                    Toast.makeText(
                        this@MainActivity,
                        " cancelada!!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            btnCorrutinaProgressBar.isEnabled = true
            btnCorrutinaProgressBarCancel.isEnabled = false
            Corrutina_progressBar.progress = 0
        }
        btnNotificacion.setOnClickListener {
            makenotification()
        }
    }

    private fun makeDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            setTitle(getString(R.string.Pruebas))
            setMessage(getString(R.string.mensaje1))
            setPositiveButton(getString(R.string.dialog_button_positivo)) {_,_->
                Toast.makeText(this@MainActivity, getString(R.string.positivo), Toast.LENGTH_SHORT).show()
            }
            setNegativeButton(getString(R.string.dialog_button_negativo)) {_,_->
                Toast.makeText(this@MainActivity, getString(R.string.negativo), Toast.LENGTH_SHORT).show()
            }
            setNeutralButton(getString(R.string.dialog_button_neutral)) {_,_->
                Toast.makeText(this@MainActivity, getString(R.string.neutral), Toast.LENGTH_SHORT).show()
            }
            alertDialog.show()
        }
    }

    private fun makeDialogSingleList() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            setTitle(getString(R.string.Pruebas))
            setItems(R.array.city) { _,position->
                val city = resources.getStringArray(R.array.city)[position]
                val message = getString(R.string.toast_message)
                val messageFormated = String.format(message, city)
                Toast.makeText(this@MainActivity, messageFormated, Toast.LENGTH_SHORT).show()
            }
        }
        alertDialog.show()
    }

    private fun makeDialogSingleChoice() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            setTitle(getString(R.string.Pruebas))
            setSingleChoiceItems(R.array.city, -1) {_,position->
                val city = resources.getStringArray(R.array.city)[position]
                val message = getString(R.string.toast_message)
                val messageFormated = String.format(message, city)
                Toast.makeText(this@MainActivity, messageFormated, Toast.LENGTH_SHORT).show()
            }
            setPositiveButton(getString(R.string.dialog_button_positivo)) {_,_->
                Toast.makeText(this@MainActivity, getString(R.string.positivo), Toast.LENGTH_SHORT).show()
            }
        }
        alertDialog.show()
    }


    private fun makeDialogMultiChoice() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            setTitle(getString(R.string.Pruebas))
            setMultiChoiceItems(R.array.city, null) {_,position,isChecked->
                val city = resources.getStringArray(R.array.city)[position]
                val message = getString(R.string.toast_message)
                val messageFormated = String.format(message, city)
                Toast.makeText(this@MainActivity, messageFormated, Toast.LENGTH_SHORT).show()
            }
            setPositiveButton(getString(R.string.dialog_button_positivo)) {_,_->
                Toast.makeText(this@MainActivity, getString(R.string.positivo), Toast.LENGTH_SHORT).show()
            }
        }
        alertDialog.show()
    }

    private fun makeCustomDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            setView(layoutInflater.inflate(R.layout.dialog_login, null))
            setPositiveButton(getString(R.string.dialog_button_positivo)) {dialog,_->
                val userName = (dialog as AlertDialog).username.text
                val userPassword = (dialog).password.text
                Toast.makeText(this@MainActivity, "El usuario es $userName y contraselña $userPassword", Toast.LENGTH_SHORT).show()
            }
        }

        alertDialog.show()
    }
    private fun makeTimePicker() {
        val cal = Calendar.getInstance()
        val timePickerDialogListener = TimePickerDialog.OnTimeSetListener { _, hour, minute ->
            Toast.makeText(this@MainActivity,
                "$hour $minute",
                Toast.LENGTH_SHORT).show()
        }

        TimePickerDialog(this, timePickerDialogListener,
            cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE),
            true,).show()
    }
    private fun makeDataPicker() {
        val cal = Calendar.getInstance()
        val datePickerListener = DatePickerDialog.OnDateSetListener { _, Year, Month, Day ->
            cal.set(Year, Month, Day)
            Toast.makeText(this@MainActivity,
                "$Year $Month $Day",
                Toast.LENGTH_SHORT).show()
        }
        DatePickerDialog(this, datePickerListener,
            cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun makeProgressBar() {
        var progressBarStatus = 0
        progressBar.progress = 0
        btnProgressBar.isEnabled = false
        var runnable = Runnable {
            while (progressBarStatus < 100) {
                progressBarStatus += 10
                Thread.sleep(1000)
                progressBar.progress = progressBarStatus
            }
            // Acciones que se realizarán al finalizar la tarea.
            this@MainActivity.runOnUiThread {
                Toast.makeText(
                    this@MainActivity,
                    "Tarea finalizada!!!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        Thread(runnable).start()
    }

    private fun makeTask(
        duracion: Int, btnStart: Button,
        btnCancel: Button, progressBar: ProgressBar
        ) = GlobalScope.launch(Dispatchers.Main) {
        // Preparación de la corrutina.
        btnStart.isEnabled = false
        btnCancel.isEnabled = true
        progressBar.progress = 0

        withContext(Dispatchers.IO) { // Tarea principal.
            var contador = 0
            while (contador < duracion) {
                if(task((duracion * 50).toLong())) {
                    contador++
                    progressBar.progress = (contador * 100) / duracion
                    }
                }
            }

        // Finaliza la corrutina.
        btnStart.isEnabled = true
        btnCancel.isEnabled = false
        progressBar.progress = 0

        Toast.makeText(
                this@MainActivity,
        "${btnStart.text} finalizada!!",
        Toast.LENGTH_SHORT
                ).show()
        }

    private suspend fun task(duracion: Long): Boolean {
        Log.d("SUSPEND FUN", "Simulando una tarea!")
        delay(duracion)
        return true
        }
    private val CHANNELID = "es.javiercarrasco.mynotifications"
    private val notificationId = 123456
    private fun makenotification() {
        val builder = NotificationCompat.Builder(this, CHANNELID)
        builder.apply {
            setSmallIcon(R.mipmap.ic_launcher_round)
            setContentTitle("Mi primera notificación")
            setContentText("Esta será la primera notificación creada.")
            priority = NotificationCompat.PRIORITY_DEFAULT
                    }
        with(NotificationManagerCompat.from(this)) {
            notify(notificationId, builder.build())
            }
    }
}
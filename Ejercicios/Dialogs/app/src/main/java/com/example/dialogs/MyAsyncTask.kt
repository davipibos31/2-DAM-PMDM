package com.example.dialogs

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar

class MyAsyncTask(
    val contexto: Context,
    val progressBar: ProgressBar,
    val botonStart: Button,
    val botonCancelar: Button
) : AsyncTask<Int,Int,Int>() {

    override fun doInBackground(vararg params: Int?): Int {
        if (params.size == 2) {
            var contador = 0
            while (contador < params[0]!!) {
                try {
                    contador++
                    Thread.sleep(params[1]!!.toLong())
                    } catch (e: Exception) {
                    Log.println(
                            Log.WARN,
                    "doInBackground",
                    e.message.toString()
                    )
                    }
                // Comprobamos si la tarea ha sido cancelada.
                if (!isCancelled)
                    publishProgress(
                            (((contador + 1) * 100 / params[0]!!).toFloat()).toInt()
                )
                else break
            }
            return 1
        } else return -1
    }

    override fun onPreExecute() {
        super.onPreExecute()
        progressBar.progress = 0
        botonStart.isEnabled = false
        botonCancelar.isEnabled = true
    }

    override fun onPostExecute(result: Int?) {
        super.onPostExecute(result)
        botonStart.isEnabled = false
        botonCancelar.isEnabled = true
    }
    override fun onCancelled() {
        super.onCancelled()
        botonCancelar.isEnabled = false
        botonStart.isEnabled = true
        progressBar.progress = 0
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        progressBar.progress = values[0]!!
    }
}
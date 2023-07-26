package com.example.dbadapter.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dbadapter.R
import com.example.dbadapter.model.Amigo
import com.example.dbadapter.model.DBHelper
import com.example.dbadapter.model.DBHelperApplication
import kotlinx.android.synthetic.main.activity_mainv2.*

const val UPDATE = "update"
const val DELETE = "delete"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainv2)
        val dbHelper = DBHelper(this, null)
        //dbHelper.addAmigo("David", "del amor")
        //DBHelperApplication.dataSource.addAmigo("da", "pi")
        //dbHelper.addAmigo("David2", "del amor2")

//        DBHelperApplication.dataSource.delAmigo(1)
//        DBHelperApplication.dataSource.delAmigo(2)
//        DBHelperApplication.dataSource.delAmigo(3)
//        DBHelperApplication.dataSource.delAmigo(4)
//        DBHelperApplication.dataSource.delAmigo(5)
//        DBHelperApplication.dataSource.delAmigo(6)
//        DBHelperApplication.dataSource.delAmigo(7)
//        DBHelperApplication.dataSource.delAmigo(8)
//        DBHelperApplication.dataSource.delAmigo(9)


       // var list1 = DBHelperApplication.dataSource.getAmigos()
        //Log.d("DBHELPER", list1.toString())

        var list = dbHelper.getAmigos()
        Log.d("DBHELPER", list.toString())

        setListener()
    }

    override fun onStart() {
        super.onStart()
        setData()
    }

    private fun setData(){
       val amigos = DBHelperApplication.dataSource.getAmigos()
        tvResult.text = ""
        amigos.forEach{
            tvResult.append("${it.id} - ${it.nombre} ${it.apellidos}\n ")
        }
    }

    private fun setListener(){
        btnInsertar.setOnClickListener{
            DBHelperApplication.dataSource.addAmigo(etNombre.text.toString(), etApes.text.toString())
            setData()
        }
        btnActualizar.setOnClickListener{
            solicitaIdentificador(UPDATE)
        }
        btnEliminar.setOnClickListener{
            solicitaIdentificador(DELETE)
        }
    }

    fun solicitaIdentificador(accion: String) {

        // Se infla la vista para el diálogo.
        val myDialogView = LayoutInflater.from(this@MainActivity)
            .inflate(R.layout.dialogo, null)

        // Se crea el builder.
        val builder = AlertDialog.Builder(this)
            .setView(myDialogView)

        builder.apply {
            setPositiveButton(android.R.string.ok) { dialog, _ ->
                val valor = myDialogView
                    .findViewById<EditText>(R.id.identificador).text
                val identificador = valor.toString().toInt()

                // Se realiza la acción.
                when (accion) {
                    UPDATE -> {
                        val nombre = etNombre.text.toString()
                        val apellido = etApes.text.toString()
                        DBHelperApplication.dataSource.updateAmigo(identificador, nombre, apellido)

                        // Se limpian los EditText después de la inserción.
                        etNombre.text.clear()
                        etApes.text.clear()
                        setData()
                    }
                    DELETE -> {
                        myToast(
                            "Eliminado/s " +
                                    "${DBHelperApplication.dataSource.delAmigo(identificador)} " +
                                    "registro/s"
                        )
                        setData()
                    }
                }
            }
            setNegativeButton(android.R.string.cancel) { dialog, _ ->
                dialog.dismiss()
            }
        }.show()
    }
    fun myToast(mensaje: String) {
        Toast.makeText(
            this@MainActivity,
            mensaje,
            Toast.LENGTH_SHORT
        ).show()
    }
}
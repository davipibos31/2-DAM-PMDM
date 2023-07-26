package com.example.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val personas =
        arrayOf(
                "Javier", "Pedro", "Nacho", "Patricia",
    "Miguel", "Susana", "Raquel", "Antonio", "Andrea",
    "Nicolás", "Juan José", "José Antonio", "Daniela",
    "María", "Verónica"
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setView()
    }

    // CONTEXT MENU DEL LISTVIEW
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
        ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_list, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        // Se obtiene el nombre de la persona, con
        // ApaterView.AdapterContextMenuInfo se obtiene la posición
        // sobre la que se ha hecho clic.
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val posicion = info.position
        val nombre = personas[posicion]
        return when (item.itemId) {
            R.id.option01 -> {
                myToast("Opción 1: $nombre")
                true
            }
            R.id.option02 -> {
                myToast("Opción 2: $nombre")
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }



    private fun setView() {
        // Se monta la vista para la lista de nombres.
        val arrayAdapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, personas)
        val listview: ListView = findViewById(R.id.listview)
        listview.adapter = arrayAdapter

        //Menu contextual al presional un elemento en el listado
        registerForContextMenu(listview)
    }

    // TOPBAR MENU
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu, menu)
        return true
        }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.op01 -> {
                Log.d("MENU", "${getString(R.string.op1)} seleccionada")
                myToast("${getString(R.string.op1)} seleccionada")
            }
        }
        return true
    }
    private fun myToast(mensaje: String) {
        Toast.makeText(
                this,
        mensaje,
        Toast.LENGTH_SHORT
                ).show()
        }
    }
package com.example.adapter

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val nombres = arrayOf(
        "Javier", "Nacho", "Patricia", "Miguel", "Susana", "Rosa", "Juan",
        "Pedro", "Asunción", "Antonio", "Lorena", "Verónica", "Paola",
        "Esteban", "Andrea", "María")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val adapter = ArrayAdapter(this, R.layout.listview_item, nombres)
        val items = ArrayList<Persona>()
        items.add(Persona("David", R.mipmap.ic_launcher))
        items.add(Persona("Daniel", R.mipmap.ic_launcher))
        items.add(Persona("Devora", R.mipmap.ic_launcher))
        val adapter = PersonaAdapter(items)
        myListView.adapter = adapter
        myListView.setOnItemClickListener { adapterView, view, i, l ->
            val nombre = adapter.getItem(i)
            //Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()
        }
    }
}
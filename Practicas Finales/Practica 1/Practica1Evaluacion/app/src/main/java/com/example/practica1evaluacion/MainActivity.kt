package com.example.practica1evaluacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object Filtros { var filtro2 = -1 }
    private lateinit var adapter: PetsGrid

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        camVentListen()
        initSpinClass()
        inView()
        cerrar()
    }

    private fun inView() {

        adapter = PetsGrid(this, Pets.lista, filtro2)
        grvi.adapter = adapter
    }

    private fun cerrar() {

        btncerrar1.setOnClickListener {
            super.finish()
        }
    }

    private fun camVentListen() {

        btnmeter.setOnClickListener {
            val myIntent = Intent(this, SecondActivity::class.java)
            startActivity(myIntent)
        }

        grvi.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, ItemPets::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        }
    }

    private fun initSpinClass() {

        ArrayAdapter.createFromResource(this, R.array.filtro_array, android.R.layout.simple_spinner_item).also {
                adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spiner1.adapter = adapter
        }

        spiner1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (spiner1.selectedItem) {
                    "Sin filtro" -> {
                        filtro2 = -1
                    }
                    "Filtro por Nombre" -> {
                        filtro2 = 0
                    }
                    "Filtro por Amor" -> {
                        filtro2 = 1
                    }
                    "Filtro por Favoritos" -> {
                        filtro2 = 2
                    }
                }
                inView()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        println("Entra en el filtro con valor = $filtro2")
        when (filtro2) {
            2 -> {
                spiner1.setSelection(3)
            }

            1 -> {
                spiner1.setSelection(2)
            }

            0 -> {
                spiner1.setSelection(1)
            }

            -1 -> {
                spiner1.setSelection(0)
            }
        }
    }
}
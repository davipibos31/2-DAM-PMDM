package com.example.shared.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.shared.*
import com.example.shared.ui.model.DBHelperApplication
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.principal_activity.*
import kotlinx.android.synthetic.main.principal_activity.view.*

class PrincipalFragments: Fragment() {
    companion object Filtros { var filtro2 = -1 }
    private lateinit var adapter: PetsGrid
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.principal_activity,
            container,
            false
        )
        initSpinClass(view)
        camVentListen(view)
        return view
    }
    private fun inView() {

        adapter = PetsGrid(requireContext(), Pets.lista, filtro2)
        grvi.adapter = adapter

    }
    private lateinit var listPersons: ArrayList<DatosV2>
    private fun camVentListen(view: View) {

        view.btnmeter.setOnClickListener {
            val myIntent = Intent(requireContext(), requireActivity()::class.java)
            startActivity(myIntent)
        }

        view.grvi.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(requireContext(), ItemPets::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        }
        view.grvi.onItemLongClickListener =
            AdapterView.OnItemLongClickListener { _, _, pos, _ -> // TODO Auto-generated method stub
                val alertDialog = AlertDialog.Builder(requireContext())
                alertDialog.apply {
                    setTitle(getString(R.string.Pruebas2))
                    setMessage(getString(R.string.mensaje2))
                    setPositiveButton(getString(R.string.dialog_button_positivo)) { _, _ ->
                        Snackbar.make(root_layout3,
                            "Seleccionado eliminado con IMC: " + listPersons[pos].nom,
                            Snackbar.LENGTH_LONG).show()
                        DBHelperApplication.dataSource.delAmigo(listPersons[pos].nom)
                        listPersons = DBHelperApplication.dataSource.getAmigos()
                        //adapter = PetsGrid(requireContext(), Pets.lista, filtro2)
                        grvi.adapter = adapter
                       // adapter = PetsGrid(requireContext(), listPersons, filtro2)
                    }
                    setNegativeButton(getString(R.string.dialog_button_negativo)) { _, _ ->


                    }
                    alertDialog.show()
                }

                Log.v("long clicked", "pos: $pos")
                true
            }
    }

    private fun initSpinClass(view: View) {

        ArrayAdapter.createFromResource(requireContext(), R.array.filtro_array, android.R.layout.simple_spinner_item).also {
                adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            view.spiner1.adapter = adapter
        }

        view.spiner1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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
                view.spiner1.setSelection(3)
            }

            1 -> {
                view.spiner1.setSelection(2)
            }

            0 -> {
                view.spiner1.setSelection(1)
            }

            -1 -> {
                view.spiner1.setSelection(0)
            }
        }
    }
}
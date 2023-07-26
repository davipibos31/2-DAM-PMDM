package com.example.shared

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.pets_grid_activity.view.*

class PetsGridV2(context: Context, items: ArrayList<DatosV2>, filtro: Int) : BaseAdapter() {

    private var cont: Context?=null
    private var elemento:ArrayList<DatosV2>

    init{

        this.cont=context
        this.elemento=items

        when (filtro) {
            -1 -> {}
            0 ->{
                this.elemento.sortBy { it.nom }
            }

            1 -> {
                this.elemento.sortBy { it.amor }
            }

            2 -> {
                val newlist = ArrayList<DatosV2>()
                for (item in items ) {
                    if(item.getFavorit()) {
                        newlist.add(item)
                    }
                }

                if (newlist.isEmpty()) {
                    this.elemento = items
                } else {
                    this.elemento = newlist
                }
            }
        }
    }

    override fun getCount(): Int { return this.elemento.size }

    override fun getItem(position: Int): DatosV2 { return this.elemento[position] }

    override fun getItemId(position: Int): Long { return position.toLong() }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {

        val item1=this.elemento[position]
        val inflater= LayoutInflater.from(cont)
        val view = inflater.inflate(R.layout.pets_grid_activity, p2, false)
        view.nombrevista.text = item1.nom
        view.nombrevista.text=item1.nomcient
        //view.imagenperfil.setImageURI(item1.fotov.toUri())

        return view
    }
}
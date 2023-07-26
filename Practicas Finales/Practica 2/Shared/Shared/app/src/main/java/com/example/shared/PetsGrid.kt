package com.example.shared

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.pets_grid_activity.view.*
import kotlinx.android.synthetic.main.second_activity.view.*
import kotlin.collections.ArrayList
import java.util.*

class PetsGrid(context: Context, items: ArrayList<Datos>, filtro: Int) : BaseAdapter() {

    private var cont: Context?=null
    private var elemento:ArrayList<Datos>

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
                val newlist = ArrayList<Datos>()
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

    override fun getItem(position: Int): Datos { return this.elemento[position] }

    override fun getItemId(position: Int): Long { return position.toLong() }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {

        val item1=this.elemento[position]
        val inflater= LayoutInflater.from(cont)
        val view = inflater.inflate(R.layout.pets_grid_activity, p2, false)
        view.nombrevista.text = item1.nom
        view.nombrevista.text=item1.nomcient
        view.imagenperfil.setImageDrawable(item1.fotov)

        return view
    }
}
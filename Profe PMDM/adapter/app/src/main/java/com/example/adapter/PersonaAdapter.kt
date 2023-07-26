package com.example.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.code_item.view.*

class PersonaAdapter : BaseAdapter {
    var itemList = ArrayList<Persona>()
    var context: Context? = null

    constructor(context: Context, itemList: ArrayList<Persona>) {
        this.itemList = itemList
        this.context = context
    }

    override fun getCount(): Int {
        return this.itemList.size
    }

    override fun getItem(posicion: Int): Any {
        return this.itemList[posicion]
    }

    override fun getItemId(posicion: Int): Long {
        return posicion.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val item = this.itemList[p0]

        var inflator = LayoutInflater.from(context)
        var view = inflator.inflate(R.layout.code_item, p2)

        view.textView.setText(item.name)
        view.imageView.setImageResource(item.image!!)
        return view
    }
}
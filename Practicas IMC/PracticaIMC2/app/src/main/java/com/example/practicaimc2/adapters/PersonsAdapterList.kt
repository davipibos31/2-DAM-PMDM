package com.example.practicaimc2.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.practicaimc2.R
import com.example.practicaimc2.person.Persons
import kotlinx.android.synthetic.main.adapter_persons.view.*

class PersonsAdapterList(private val context: Context, list: List<Persons>): BaseAdapter() {

    private var persons = ArrayList<Persons>()
    init {
        persons = list as ArrayList<Persons>
        //persons.clear()
    }
    override fun getCount(): Int {
        return persons.size
    }

    override fun getItem(p0: Int): Any {
        return persons[0]
    }

    override fun getItemId(p0: Int): Long {
       return p0.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val item = this.persons[p0]
        val inflator = LayoutInflater.from(context)
        val view = inflator.inflate(R.layout.adapter_persons, p2, false)
        view.textView.text = item.altura
        view.imc2.text = item.imc
        view.peso2.text = item.peso
        view.cat2.text = item.cat
        return view
    }

    fun setPersons(listPersons: List<Persons>) {
        persons = listPersons as ArrayList<Persons>
        notifyDataSetChanged()
    }
}
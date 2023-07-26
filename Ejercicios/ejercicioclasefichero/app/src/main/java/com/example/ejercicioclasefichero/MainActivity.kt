package com.example.ejercicioclasefichero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicioclasefichero.data.person.IPersonsDataSource
import com.example.ejercicioclasefichero.data.person.Persons
import com.example.ejercicioclasefichero.data.person.PersonsFileDataSource
import com.example.ejercicioclasefichero.ui.adapters.PersonsAdapterList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var PersonsFileDataSource : IPersonsDataSource
    private lateinit var listPersons: List<Persons>
    private lateinit var adapter : PersonsAdapterList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setView()
        setListener()
    }
    private fun setView() {
        PersonsFileDataSource = PersonsFileDataSource(this, "fichero.txt")
        PersonsFileDataSource.getList(this)
        listPersons = PersonsFileDataSource.getList(this)
        adapter = PersonsAdapterList(this, listPersons)
        list.adapter = adapter
    }

    private fun setListener() {
        button.setOnClickListener {
            listPersons += Persons("gdfgdfgdfg", "gfdgdfgdfgd", 23)
            PersonsFileDataSource.saveList(this, listPersons)
            listPersons = PersonsFileDataSource.getList(this)
            adapter.setPersons(listPersons)
        }
    }
}
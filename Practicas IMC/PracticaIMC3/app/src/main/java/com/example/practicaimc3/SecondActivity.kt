@file:Suppress("PrivatePropertyName")

package com.example.practicaimc3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practicaimc3.adapters.PersonsAdapterList
import com.example.practicaimc3.person.IPersonsDataSource
import com.example.practicaimc3.person.Persons
import com.example.practicaimc3.person.PersonsFileDataSource
import kotlinx.android.synthetic.main.listactivity.*

class SecondActivity : AppCompatActivity() {
    private lateinit var PersonsFileDataSource : IPersonsDataSource
    private lateinit var listPersons: List<Persons>
    private lateinit var adapter : PersonsAdapterList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listactivity)
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
            @Suppress("SuspiciousCollectionReassignment")
            listPersons += Persons(MainActivity.altura.toString(), MainActivity.peso.toString(), MainActivity.imc.toString(), MainActivity.cat, MainActivity.sexo)
            PersonsFileDataSource.saveList(this, listPersons)
            listPersons = PersonsFileDataSource.getList(this)
            adapter.setPersons(listPersons)

        }
    }
}

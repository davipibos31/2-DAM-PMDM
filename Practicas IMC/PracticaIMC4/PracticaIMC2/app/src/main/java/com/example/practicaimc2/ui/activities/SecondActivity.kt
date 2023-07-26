@file:Suppress("PrivatePropertyName")

package com.example.practicaimc2.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practicaimc2.R
import com.example.practicaimc2.adapters.PersonsAdapterList
import com.example.practicaimc2.person.IPersonsDataSource
import com.example.practicaimc2.person.Persons
import com.example.practicaimc2.person.PersonsFileDataSource
import com.example.practicaimc2.ui.fragments.FragmentA.Companion.altura
import com.example.practicaimc2.ui.fragments.FragmentA.Companion.cat
import com.example.practicaimc2.ui.fragments.FragmentA.Companion.imc
import com.example.practicaimc2.ui.fragments.FragmentA.Companion.peso
import com.example.practicaimc2.ui.fragments.FragmentA.Companion.sexo
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
                listPersons += Persons(altura.toString(), peso.toString(), imc.toString(), cat, sexo)
                PersonsFileDataSource.addPersona(altura.toString(), peso.toString(), imc.toString(), cat, sexo)
                PersonsFileDataSource.saveList(this, listPersons)
                listPersons = PersonsFileDataSource.getList(this)
                adapter.setPersons(listPersons)

        }
    }
}

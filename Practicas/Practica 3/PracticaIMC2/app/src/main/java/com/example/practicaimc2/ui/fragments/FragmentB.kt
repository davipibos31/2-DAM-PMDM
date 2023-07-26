package com.example.practicaimc2.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.practicaimc2.R
import com.example.practicaimc2.adapters.PersonsAdapterList
import com.example.practicaimc2.person.IPersonsDataSource
import com.example.practicaimc2.person.Persons
import com.example.practicaimc2.person.PersonsFileDataSource
import kotlinx.android.synthetic.main.listactivity.*

@Suppress("PrivatePropertyName")
class FragmentB : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
        setListener()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }
    private lateinit var PersonsFileDataSource : IPersonsDataSource
    private lateinit var listPersons: List<Persons>
    private lateinit var adapter : PersonsAdapterList

    private fun setView() {
        PersonsFileDataSource = PersonsFileDataSource(requireContext(), "fichero.txt")
        PersonsFileDataSource.getList(requireContext())
        listPersons = PersonsFileDataSource.getList(requireContext())
        adapter = PersonsAdapterList(requireContext(), listPersons)
        list.adapter = adapter
    }

    private fun setListener() {
        button.setOnClickListener {
            @Suppress("SuspiciousCollectionReassignment")
            listPersons += Persons(FragmentA.altura.toString(), FragmentA.peso.toString(), FragmentA.imc.toString(), FragmentA.cat, FragmentA.sexo)
            PersonsFileDataSource.saveList(requireContext(), listPersons)
            listPersons = PersonsFileDataSource.getList(requireContext())
            adapter.setPersons(listPersons)

        }
    }
}
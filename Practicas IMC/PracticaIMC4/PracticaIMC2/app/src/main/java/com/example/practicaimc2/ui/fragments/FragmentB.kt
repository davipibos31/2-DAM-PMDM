package com.example.practicaimc2.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import android.widget.AdapterView.OnItemLongClickListener
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.practicaimc2.adapters.PersonsAdapterList
import com.example.practicaimc2.person.*
import com.example.practicaimc2.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_a.*
import kotlinx.android.synthetic.main.fragment_a.view.*
import kotlinx.android.synthetic.main.fragment_b.*
import kotlinx.android.synthetic.main.listactivity.*
import kotlinx.android.synthetic.main.listactivity.button
import kotlinx.android.synthetic.main.listactivity.list
import kotlinx.android.synthetic.main.listactivity.view.*

@Suppress("PrivatePropertyName")
class FragmentB : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
        setListener()
        setListenerlist()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }
    private lateinit var PersonsFileDataSource : IPersonsDataSource
    private lateinit var listPersons: List<Persons>
    private lateinit var adapter : PersonsAdapterList

    private fun setView() {
        PersonsFileDataSource = PersonsFileDataSource(requireContext(), "fichero.txt")
        //PersonsFileDataSource.getList(requireContext())
        //listPersons = PersonsFileDataSource.getList(requireContext())
        listPersons = DBHelperApplication.dataSource.getAmigos()

        adapter = PersonsAdapterList(requireContext(), listPersons)
        list.adapter = adapter
    }

    private fun setListener() {
        button.setOnClickListener {
            @Suppress("SuspiciousCollectionReassignment")
            listPersons += Persons(FragmentA.altura.toString(), FragmentA.peso.toString(), FragmentA.imc.toString(), FragmentA.cat, FragmentA.sexo)
            PersonsFileDataSource.saveList(requireContext(), listPersons)
            listPersons = DBHelperApplication.dataSource.getAmigos()
            adapter.setPersons(listPersons)

        }
    }
    private fun setListenerlist(){
        list.onItemLongClickListener = OnItemLongClickListener { _, _, pos, _ -> // TODO Auto-generated method stub
            val alertDialog = AlertDialog.Builder(requireContext())
            alertDialog.apply {
                setTitle(getString(R.string.Pruebas2))
                setMessage(getString(R.string.mensaje2))
                setPositiveButton(getString(R.string.dialog_button_positivo)) {_,_->
                    Snackbar.make(root_layout3, "Seleccionado eliminado con IMC: " + listPersons[pos].imc, Snackbar.LENGTH_LONG).show()
                    DBHelperApplication.dataSource.delAmigo(listPersons[pos].imc)
                    listPersons = DBHelperApplication.dataSource.getAmigos()
                    adapter.setPersons(listPersons)
                    PersonsFileDataSource.saveList(requireContext(), listPersons)
                }
                setNegativeButton(getString(R.string.dialog_button_negativo)) {_,_->


                }
                alertDialog.show()
            }

            Log.v("long clicked", "pos: $pos")
            true
        }
    }
}

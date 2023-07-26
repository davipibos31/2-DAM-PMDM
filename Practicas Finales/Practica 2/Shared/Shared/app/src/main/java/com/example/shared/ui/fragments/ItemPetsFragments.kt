package com.example.shared.ui.fragments


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shared.R
import com.example.shared.ui.model.DBHelperApplication
import kotlinx.android.synthetic.main.listactivity.view.*


class ItemPetsFragments: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.listactivity,
            container,
            false
        )
        basedatos(view)
        setListener(view)
        return view
    }

    private val amigos = DBHelperApplication.dataSource.getAmigos()

    private fun basedatos(view: View) {
        view.list.text = ""
        amigos.forEach{
            view.list.append("Nombre: ${it.nom}\n " +
                    "Nombre Cientifico: ${it.nomcient}\n Tipo pelo: ${it.tipopelaje}\n " +
                    "Clase: ${it.clas}\n Amorosidad: ${it.amor}\n Foto: ${it.fotov}\n " +
                    "Enlace: ${it.enlaces}\n\n\n\n\n ")
        }
    }

    private fun setListener(view: View) {
        view.button.setOnClickListener{
            val myIntent = Intent(requireContext(), requireActivity()::class.java)
            startActivity(myIntent)
        }
    }

}
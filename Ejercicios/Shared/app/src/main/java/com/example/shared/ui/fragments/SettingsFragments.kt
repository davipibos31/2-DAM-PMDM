package com.example.shared.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shared.SharedApp
import com.example.shared.R
import kotlinx.android.synthetic.main.fragments_setting.view.*

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragments_setting,
            container,
            false
        )
        setData(view)
        setListener(view)
        return view
    }

    private fun setData(view: View) {
        view.et_name.setText(SharedApp.preferences.name)
    }

    private fun setListener(view: View) {
        view.btn_deletePrefs.setOnClickListener {
            SharedApp.preferences.deletePrefs()
            setData(view)
        }
    }
/*
    override fun onBackPressed() {
        // La clase Preferences se encarga de editar y guardar en la asignación.
        if (!et_name.text.isEmpty()){
            Application.preferences.name = et_name.text.toString()
        }
        super.onBackPressed()
    }*/
}
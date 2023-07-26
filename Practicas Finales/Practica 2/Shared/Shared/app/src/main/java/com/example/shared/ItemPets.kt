package com.example.shared

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.shared.Pets.Companion.lista
import kotlinx.android.synthetic.main.pets_items_activity.*
import kotlinx.android.synthetic.main.second_activity.btnsalir

class ItemPets : AppCompatActivity() {

    private var pos1: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pets_items_activity)
        camVenListen()
        sacarDatos()
        estrefavoritoListen()
        openWeb()
    }

    private fun tikfavorito() {
        val favorit = lista[pos1].getFavorit()// == true
        val starOff = android.R.drawable.btn_star_big_off
        val starOn = android.R.drawable.btn_star_big_on
        if (!favorit) {
            estrella.setImageResource(starOff)
        } else {
            estrella.setImageResource(starOn)
        }
    }

    private fun estrefavoritoListen() {
        val starOff = android.R.drawable.btn_star_big_off
        val starOn = android.R.drawable.btn_star_big_on
        estrella.setOnClickListener {
            val favorit = lista[pos1].getFavorit()
            if (!favorit) {
                estrella.setImageResource(starOn)
            } else {
                estrella.setImageResource(starOff)
            }
            lista[pos1].setFavorit(!favorit)
        }
    }

    private fun camVenListen() {
        btnsalir.setOnClickListener {

        }
    }

    private fun sacarDatos() {
        this.pos1 = intent.getIntExtra("position", -1)

        pelo1.text = lista[pos1].tipopelaje
        nombreinfo1.text = lista[pos1].nom
        foto.setImageDrawable(lista[pos1].fotov)
        amor1.text = lista[pos1].amor
        clase1.text = lista[pos1].clas
        enlace1.text = lista[pos1].enlaces
        cientifico1.text = lista[pos1].nomcient
        tikfavorito()
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun openWeb() {
        enlace1.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(enlace1.text.toString()))
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Log.d("DEBUG", "Hay un problema para encontrar un navegador.")
            }
        }
    }
}
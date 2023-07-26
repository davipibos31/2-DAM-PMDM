package com.example.shared

import android.app.Application

class Pets: Application() {
    companion object {
        var lista = ArrayList<Datos>()
        private var lista2 = ArrayList<Datos>()

        var lista3 = ArrayList<DatosV2>()
        private var lista4 = ArrayList<DatosV2>()

        fun add( ob: Datos) {
            lista.add(ob)
            lista2.add(ob)
        }
        fun addV2( ob: DatosV2) {
            lista3.add(ob)
            lista4.add(ob)
        }
    }
}
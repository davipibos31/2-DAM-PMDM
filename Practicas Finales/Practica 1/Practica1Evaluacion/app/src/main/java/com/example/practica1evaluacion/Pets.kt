package com.example.practica1evaluacion

class Pets {
    companion object {
        var lista = ArrayList<Datos>()
        private var lista2 = ArrayList<Datos>()

        fun add( ob:Datos ) {
            lista.add(ob)
            lista2.add(ob)
        }
    }
}
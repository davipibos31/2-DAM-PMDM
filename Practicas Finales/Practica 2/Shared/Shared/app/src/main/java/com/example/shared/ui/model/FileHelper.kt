package com.example.shared.ui.model

import com.example.shared.DatosV2

class FileHelper: IDBHelper {

    override fun addAmigo(
        name: String,
        nomcient: String,
        tipopelaje: String,
        clas: String,
        amor: String,
        foto: String,
        enlace: String,
    ) {
        TODO("Not yet implemented")
    }

    override fun delAmigo(name: String): Int {
        TODO("Not yet implemented")
    }

    override fun getAmigos(): ArrayList<DatosV2> {
        TODO("Not yet implemented")
    }

    override fun getAmigosByID(id: Int): DatosV2? {
        TODO("Not yet implemented")
    }

    override fun updateAmigo(id: Int, nombre: String, apellido: String): Int {
        TODO("Not yet implemented")
    }

}
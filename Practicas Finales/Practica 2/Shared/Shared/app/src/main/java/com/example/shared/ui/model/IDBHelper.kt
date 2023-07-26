package com.example.shared.ui.model

import com.example.shared.Datos
import com.example.shared.DatosV2

interface IDBHelper {
    fun addAmigo(name: String, nomcient: String, tipopelaje: String, clas: String, amor: String, foto: String, enlace: String)
    fun delAmigo(name: String/*, nombre: String*/) : Int
    fun getAmigos(): ArrayList<DatosV2>
    fun getAmigosByID(id: Int): DatosV2?
    fun updateAmigo(id: Int, nombre: String, apellido: String) : Int
}
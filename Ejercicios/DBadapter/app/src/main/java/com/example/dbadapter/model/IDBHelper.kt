package com.example.dbadapter.model



interface IDBHelper {
    fun addAmigo(name: String, lastname: String)
    fun delAmigo(id: Int/*, nombre: String*/) : Int
    fun getAmigos(): List<Amigo>
    fun getAmigosByID(id: Int): Amigo?
    fun updateAmigo(id: Int, nombre: String, apellido: String) : Int
}
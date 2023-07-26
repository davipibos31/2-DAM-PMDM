package com.example.practicaimc2.person

interface IDBHelper {
    fun addAmigo(imc: String, altura: String, peso: String, cat: String, sexo: String)
    fun delAmigo(id: String/*, nombre: String*/) : Int
    fun getAmigos(): List<Persons>
    fun getAmigosByID(id: Int): Persons?
    fun updateAmigo(id: Int, nombre: String, apellido: String) : Int
}
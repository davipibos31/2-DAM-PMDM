package com.example.practicaimc2.person

import android.content.Context
interface IPersonsDataSource {
    fun getList(context: Context): List<Persons>
    fun saveList(context: Context, list: List<Persons> )
    fun addPersona(altura: String, peso: String, imc: String, cat: String, sexo: String)
    fun delAmigo(id: Int): Int
}
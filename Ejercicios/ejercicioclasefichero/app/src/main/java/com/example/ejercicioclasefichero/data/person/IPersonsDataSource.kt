package com.example.ejercicioclasefichero.data.person

import android.content.Context
interface IPersonsDataSource {
    fun getList(context: Context): List<Persons>
    fun saveList(context: Context, list: List<Persons> )
}
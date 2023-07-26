package com.example.practicaimc4.person

import android.content.Context

interface IPersonsDataSource {
    fun getList(context: Context): List<Persons>
    fun saveList(context: Context, list: List<Persons> )
}
package com.example.ejercicioclasefichero.data.person

import android.content.Context
import java.io.File
class PersonsFileDataSource(context: Context, val filename: String) : IPersonsDataSource {
    init {
        val file = File(filename)
        if (!file.exists()) {
            val l = ArrayList<Persons>()
            l.add(Persons("jose", "company", 1))
            l.add(Persons("sdfdsfds", "fdsfds", 2))
            l.add(Persons("fdsfds", "ghhgfjhgf", 3))
            saveList(context, l)
        }
    }
    override fun getList(context: Context): List<Persons> {
        val list = ArrayList<Persons>()
        context.openFileInput(filename).bufferedReader().useLines { lines ->
            for (s in lines){
                val splitLine = s.split(";")
                list.add(Persons(splitLine[0], splitLine[1], splitLine[2].toInt()))
            }
        }
        return list
    }
    override fun saveList(context: Context, list: List<Persons>) {
        val fileContents = StringBuffer()
        for (s in list){
            fileContents.appendLine(s.toString())
        }
        context.openFileOutput(filename, Context.MODE_PRIVATE).use {
            it.write(fileContents.toString().encodeToByteArray())
        }
    }
}
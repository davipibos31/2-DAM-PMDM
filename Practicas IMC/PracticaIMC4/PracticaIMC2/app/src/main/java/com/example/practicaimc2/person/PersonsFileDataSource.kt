package com.example.practicaimc2.person

import android.content.Context
import java.io.File

class  PersonsFileDataSource(@Suppress("UNUSED_PARAMETER") context: Context, private val filename: String) : IPersonsDataSource {

    init {
        val file = File(filename)
        if (!file.exists()) {
            @Suppress("UNUSED_VARIABLE") val l = ArrayList<Persons>()
        }
    }
    override fun getList(context: Context): List<Persons> {
        val list = ArrayList<Persons>()
        context.openFileInput(filename).bufferedReader().useLines { lines ->
            for (s in lines){
                val splitLine = s.split(";")
               // val item1: String = splitLine[0]
                list.add(Persons(splitLine[0], splitLine[1], splitLine[2],splitLine[3],splitLine[4]))
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

    override fun addPersona(
        altura: String,
        peso: String,
        imc: String,
        cat: String,
        sexo: String,
    ) {
        TODO("Not yet implemented")
    }

    override fun delAmigo(id: Int): Int {
        TODO("Not yet implemented")
    }
}
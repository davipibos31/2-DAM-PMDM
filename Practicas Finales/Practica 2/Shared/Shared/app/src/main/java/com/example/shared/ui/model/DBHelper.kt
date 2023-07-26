package com.example.shared.ui.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.shared.DatosV2


class DBHelper(context : Context, factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION),
    IDBHelper {
    private val tag = "SQLite"
    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "pets.db"
        const val TABLA_PETS = "pets"
        const val COLUMNA_NOMCIEN = "nombre_cientifico"
        const val COLUMNA_NOMBRE = "nombre"
        const val COLUMNA_TIPOPELAJE = "tipo_pelajo"
        const val COLUMNA_CLAS = "clas"
        const val COLUMNA_AMOR = "amor"
        const val COLUMNA_FOTO = "foto"
        const val COLUMNA_ENLACE = "enlace"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        try {
            val createTableAmigos = "CREATE TABLE $TABLA_PETS " +
                    "($COLUMNA_NOMBRE TEXT PRIMARY KEY, " +
                    "$COLUMNA_NOMCIEN TEXT, " +
                    "$COLUMNA_TIPOPELAJE TEXT, " +
                    "$COLUMNA_CLAS TEXT, " +
                    "$COLUMNA_AMOR TEXT, " +
                    "$COLUMNA_FOTO TEXT, " +
                    "$COLUMNA_ENLACE TEXT)"
            db!!.execSQL(createTableAmigos)
        } catch (e: SQLiteException) {
            Log.e("$tag (onCreate)", e.message.toString())
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    override fun onOpen(db: SQLiteDatabase?) {
        super.onOpen(db)
    }

    override fun addAmigo(name: String, nomcient: String, tipopelaje: String, clas: String, amor: String, foto: String, enlace: String) {
        val data = ContentValues()
        data.put(COLUMNA_NOMBRE, name)
        data.put(COLUMNA_NOMCIEN, nomcient)
        data.put(COLUMNA_TIPOPELAJE, tipopelaje)
        data.put(COLUMNA_CLAS, clas)
        data.put(COLUMNA_AMOR, amor)
        data.put(COLUMNA_FOTO, foto)
        data.put(COLUMNA_ENLACE, enlace)

        val db = this.writableDatabase
        db.insert(TABLA_PETS, null, data)
        db.close()
    }

    override fun delAmigo(name: String/*, nombre: String*/) : Int {
        val args = arrayOf(name.toString())

        val db = this.writableDatabase
        //val result = db.delete(TABLA_AMIGOS,"$COLUMNA_ID = ? and $COLUMNA_NOMBRE=?", args)
        val result = db.delete(TABLA_PETS,"${COLUMNA_NOMBRE}m = ?", args)
        db.close()
        return result
    }

    override fun getAmigos(): ArrayList<DatosV2> {

        val result = ArrayList<DatosV2>()
        val db = this.readableDatabase
        val cursor = db.rawQuery(
            "SELECT $COLUMNA_NOMBRE, $COLUMNA_NOMBRE,$COLUMNA_NOMCIEN,$COLUMNA_CLAS,$COLUMNA_AMOR,$COLUMNA_FOTO,$COLUMNA_ENLACE" +
                    " FROM $TABLA_PETS",
            null
        )

        if (cursor.moveToFirst()) {
            do {
                val nombre = cursor.getString(0)
                val nomcient = cursor.getString(1)
                val tipopelaje = cursor.getString(2)
                val clas = cursor.getString(3)
                val amor = cursor.getString(4)
                val foto = cursor.getString(5)
                val enlace = cursor.getString(6)
                val amigo = DatosV2(nombre, nomcient, tipopelaje, clas, amor, foto, enlace)
                result.add(amigo)
            } while (cursor.moveToNext())
            cursor.close()
        }
        return result
    }
    override fun getAmigosByID(id:Int):DatosV2?{
        var amigo:DatosV2?=null// le pongo que es nulo de inicio
        val args = arrayOf(id.toString())
        val db = this.readableDatabase
        val cursor = db.rawQuery(
            "SELECT  $COLUMNA_NOMBRE,$COLUMNA_NOMCIEN" +
                    "TABLA_$TABLA_PETS where $COLUMNA_NOMBRE=?", args// el args se pasa el id del array
            //
        )

        if (cursor.moveToFirst()) {
            do {

                val nombre = cursor.getString(0)
                val nomcient = cursor.getString(1)
                val tipopelaje = cursor.getString(2)
                val clas = cursor.getString(3)
                val amor = cursor.getString(4)
                val foto = cursor.getString(5)
                val enlace = cursor.getString(6)
                amigo = DatosV2(nombre, nomcient, tipopelaje, clas, amor, foto, enlace)

            } while (cursor.moveToNext())
            cursor.close()
        }
        return amigo
    }

    override fun updateAmigo(id: Int, nombre: String, apellido: String) : Int {
        val args = arrayOf(id.toString())
        val db = this.writableDatabase
        val data = ContentValues()

        data.put(COLUMNA_NOMBRE, nombre)
        data.put(COLUMNA_NOMCIEN, apellido)

        val res = db.update(TABLA_PETS, data, "$COLUMNA_NOMBRE = ?", args)
        db.close()
        return  res
    }
}





































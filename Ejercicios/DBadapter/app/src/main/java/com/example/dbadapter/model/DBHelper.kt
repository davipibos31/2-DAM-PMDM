package com.example.dbadapter.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log



class DBHelper(context : Context, factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION),
    IDBHelper {
    val TAG = "SQLite"
    companion object {
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "personas.db"
        val TABLA_AMIGOS = "amigos"
        val COLUMNA_ID = "_id"
        val COLUMNA_NOMBRE = "nombre"
        val COLUMNA_APELLIDOS = "apellidos"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        try {
            val createTableAmigos = "CREATE TABLE $TABLA_AMIGOS " +
                    "($COLUMNA_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$COLUMNA_NOMBRE TEXT, " +
                    "$COLUMNA_APELLIDOS TEXT)"
            db!!.execSQL(createTableAmigos)
        } catch (e: SQLiteException) {
            Log.e("$TAG (onCreate)", e.message.toString())
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    override fun onOpen(db: SQLiteDatabase?) {
        super.onOpen(db)
    }

    override fun addAmigo(name: String, lastname: String) {
        val data = ContentValues()
        data.put(COLUMNA_NOMBRE, name)
        data.put(COLUMNA_APELLIDOS, lastname)
        val db = this.writableDatabase
        db.insert(TABLA_AMIGOS, null, data)
        db.close()
    }

    override fun delAmigo(id: Int/*, nombre: String*/) : Int {
        val args = arrayOf(id.toString())

        val db = this.writableDatabase
        //val result = db.delete(TABLA_AMIGOS,"$COLUMNA_ID = ? and $COLUMNA_NOMBRE=?", args)
        val result = db.delete(TABLA_AMIGOS,"$COLUMNA_ID = ?", args)
        db.close()
        return result
    }

    override fun getAmigos(): List<Amigo> {

        val result = ArrayList<Amigo>()
        val db = this.readableDatabase
        val cursor = db.rawQuery(
            "SELECT $COLUMNA_ID, $COLUMNA_NOMBRE,$COLUMNA_APELLIDOS" +
                    " FROM $TABLA_AMIGOS",
            null
        )

        if (cursor.moveToFirst()) {
            do {

                val id = cursor.getInt(0)
                val nombre = cursor.getString(1)
                val apellido = cursor.getString(2)
                val amigo = Amigo(id, nombre, apellido)
                result.add(amigo)
            } while (cursor.moveToNext());

        }
        return result
    }
    override fun getAmigosByID(id:Int):Amigo?{
        var amigo:Amigo?=null// le pongo que es nulo de inicio
        val args = arrayOf(id.toString())
        val db = this.readableDatabase
        val cursor = db.rawQuery(
            "SELECT $COLUMNA_ID, $COLUMNA_NOMBRE,$COLUMNA_APELLIDOS" +
                    " FROM $TABLA_AMIGOS where $COLUMNA_ID=?", args// el args se pasa el id del array
            //
        )

        if (cursor.moveToFirst()) {
            do {

                val id = cursor.getInt(0)
                val nombre = cursor.getString(1)
                val apellido = cursor.getString(2)
                amigo = Amigo(id, nombre, apellido)

            } while (cursor.moveToNext());

        }
        return amigo
    }

    override fun updateAmigo(id: Int, nombre: String, apellido: String) : Int {
        val args = arrayOf(id.toString())
        val db = this.writableDatabase
        val data = ContentValues()

        data.put(COLUMNA_NOMBRE, nombre)
        data.put(COLUMNA_APELLIDOS, apellido)

        val res = db.update(TABLA_AMIGOS, data, "$COLUMNA_ID = ?", args)
        db.close()
        return  res
    }
}





































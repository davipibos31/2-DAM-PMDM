package com.example.practicaimc2.person

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log


class DBHelper(context : Context, factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION),
    IDBHelper {
    private val tag = "SQLite"
    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "personas.db"
        const val TABLA_AMIGOS = "amigos"
        const val COLUMNA_IMC = "imc"
        const val COLUMNA_ALTURA = "altura"
        const val COLUMNA_PESO = "peso"
        const val COLUMNA_CAT = "cat"
        const val COLUMNA_SEXO = "sexo"
        const val COLUMNA_ID = "_id"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        try {
            val createTableAmigos = "CREATE TABLE $TABLA_AMIGOS " +
                    "($COLUMNA_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$COLUMNA_IMC TEXT, " +
                    "$COLUMNA_ALTURA TEXT, " +
                    "$COLUMNA_PESO TEXT, " +
                    "$COLUMNA_CAT TEXT, " +
                    "$COLUMNA_SEXO TEXT)"
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

    override fun addAmigo(imc: String, altura: String, peso: String, cat: String, sexo: String) {
        val data = ContentValues()
        data.put(COLUMNA_IMC, imc)
        data.put(COLUMNA_ALTURA, altura)
        data.put(COLUMNA_PESO, peso)
        data.put(COLUMNA_CAT, cat)
        data.put(COLUMNA_SEXO, sexo)
        val db = this.writableDatabase
        db.insert(TABLA_AMIGOS, null, data)
        db.close()
    }

    override fun delAmigo(id: String/*, nombre: String*/) : Int {
        val args = arrayOf(id)

        val db = this.writableDatabase
        //val result = db.delete(TABLA_AMIGOS,"$COLUMNA_ID = ? and $COLUMNA_NOMBRE=?", args)
        val result = db.delete(TABLA_AMIGOS,"$COLUMNA_IMC = ?", args)
        db.close()
        return result
    }

    override fun getAmigos(): List<Persons> {

        val result = ArrayList<Persons>()
        val db = this.readableDatabase
        val cursor = db.rawQuery(
            "SELECT $COLUMNA_IMC, $COLUMNA_ALTURA,$COLUMNA_PESO, $COLUMNA_CAT, $COLUMNA_SEXO" +
                    " FROM $TABLA_AMIGOS",
            null
        )

        if (cursor.moveToFirst()) {
            do {

                val imc = cursor.getString(0)
                val altura = cursor.getString(1)
                val peso = cursor.getString(2)
                val cat = cursor.getString(3)
                val sexo = cursor.getString(4)
                val amigo = Persons(altura, peso, imc, cat, sexo)
                result.add(amigo)
            } while (cursor.moveToNext())
            cursor.close()
        }
        return result
    }
    override fun getAmigosByID(id:Int):Persons?{
        var amigo:Persons?=null// le pongo que es nulo de inicio
        val args = arrayOf(id.toString())
        val db = this.readableDatabase
        val cursor = db.rawQuery(
            "SELECT $COLUMNA_IMC, $COLUMNA_ALTURA,$COLUMNA_PESO, $COLUMNA_CAT, $COLUMNA_SEXO" +
                    " FROM $TABLA_AMIGOS where $COLUMNA_IMC=?", args// el args se pasa el id del array
            //
        )

        if (cursor.moveToFirst()) {
            do {

                val imc = cursor.getString(0)
                val altura = cursor.getString(1)
                val peso = cursor.getString(2)
                val cat = cursor.getString(3)
                val sexo = cursor.getString(4)
                amigo = Persons(altura, peso, imc, cat, sexo)

            } while (cursor.moveToNext())
            cursor.close()
        }
        return amigo
    }

    override fun updateAmigo(id: Int, nombre: String, apellido: String) : Int {
        val args = arrayOf(id.toString())
        val db = this.writableDatabase
        val data = ContentValues()

        data.put(COLUMNA_ALTURA, nombre)
        data.put(COLUMNA_PESO, apellido)

        val res = db.update(TABLA_AMIGOS, data, "$COLUMNA_IMC = ?", args)
        db.close()
        return  res
    }
}





































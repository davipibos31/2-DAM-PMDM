package com.example.ejercicioclasefichero.data.person

class Persons(val name : String, private val lastName : String, private val age : Int) {
    override fun toString(): String {
        return "$name;$lastName;$age"
    }
}
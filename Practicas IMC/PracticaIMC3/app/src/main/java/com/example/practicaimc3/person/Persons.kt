package com.example.practicaimc3.person

class Persons(val altura: String, private val peso: String, private val imc: String, private val cat: String, private val sexo : String) {
    override fun toString(): String {
        return "$altura;$peso;$imc;$cat;$sexo"
    }
}
package com.example.practicaimc2.person

class Persons(val altura: String, val peso: String, val imc: String, val cat: String, private val sexo: String) {
    override fun toString(): String {
        return "$altura;$peso;$imc;$cat;$sexo"
    }
}
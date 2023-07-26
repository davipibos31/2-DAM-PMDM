package com.example.myapplication

data class Candie(val name: String, val image: Int) {
    private var n: String? = null
    private var img: Int? = null

    init {
        this.n = name
        this.img = image
    }
}
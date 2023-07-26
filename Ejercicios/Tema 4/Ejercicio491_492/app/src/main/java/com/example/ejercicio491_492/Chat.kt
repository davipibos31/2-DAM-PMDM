package com.example.ejercicio491_492;

data class Chat(val name: String, val image:Int) {
    private var n: String? = null
    private var img: Int? = null

    init {
        this.n = name
        this.img = image
    }
}
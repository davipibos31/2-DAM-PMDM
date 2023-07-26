package com.example.shared

data class DatosV2(val nom: String, val nomcient: String, val tipopelaje: String, val clas: String, val amor: String, val fotov: String, val enlaces: String) {

    private var favorit: Boolean = false
    private var nomcient1: String? = null
    private var nom1: String? = null
    private var amor1: String? = null
    private var enlac: String? = null
    private var tipopelaje1: String? = null
    private var clas1: String? = null
    private var foto1: String? = null

    init {
        this.nom1 = nom
        this.nomcient1 = nomcient
        this.tipopelaje1 = tipopelaje
        this.clas1 = clas
        this.amor1 = amor
        this.foto1 = fotov
        this.enlac = enlaces
    }

    fun getFavorit(): Boolean {
        return this.favorit
    }
}
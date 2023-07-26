package es.alumno.listados

data class Chat(val title: String, val description: String, val image: Int) {
    private var n: String? = null
    private var desc: String? = null
    private var img: String? = null

    init {
        this.n = title
        this.desc = description
        this.img = img
    }

}
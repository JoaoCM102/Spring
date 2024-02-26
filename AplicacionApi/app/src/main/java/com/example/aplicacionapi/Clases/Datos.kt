package com.example.apiparteandroid.Clases

typealias Root = List<Root2>;

data class Root2(
    val padre: Padre ,
    val hijos: List<Hijo>,

){
    companion object {
        var valorIdPadre: Long = 0
        var valorIdHijo: Long = 0
    }
}

data class Padre(
    val padreId: Long? = null,
    val nombre: String? = null,
    val apellidos: String? = null,
    val imagen: String? = null,
){
    constructor(nombre: String?, apellidos: String?, imagen: String?) : this(null, nombre, apellidos, imagen)
}

data class Hijo(
    val hijoId: Long? = null,
    val nombre: String? = null,
    val apellidos: String? = null,
    val imagen: String? = null,
){
    constructor(nombre: String?, apellidos: String?, imagen: String?) : this(null, nombre, apellidos, imagen)
}

package com.example.practica3_joaopedrolimadias

sealed class Rutas(val ruta: String) {
    /* TODO
        Crear e identificar las rutas (diferentes pantallas) de nuestra app
     */
    object VerPadres: Rutas("VerPadres")
    object MenuInicio: Rutas("MenuInicio")

    object VerHijo: Rutas("VerHijo")

    object VerHijos: Rutas("VerHijos")

    object VerPadre: Rutas("VerPadre")

    object OperacionesRealizar: Rutas("OperacionesRealizar")

}

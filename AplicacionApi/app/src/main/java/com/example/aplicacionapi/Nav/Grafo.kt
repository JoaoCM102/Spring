package com.example.practica3_joaopedrolimadias.Nav

import android.content.Context
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apiparteandroid.Ventanas.MenuPrincipal
import com.example.aplicacionapi.Ventanas.MenuInicio
import com.example.aplicacionapi.Ventanas.OperacionesRealizar
import com.example.aplicacionapi.Ventanas.VerHijo
import com.example.aplicacionapi.Ventanas.VerHijos
import com.example.aplicacionapi.Ventanas.VerPadre
import com.example.practica3_joaopedrolimadias.Rutas

@Composable
fun GrafoNavegacion(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.MenuInicio.ruta) {

        // "URL" -> Composable
        composable(Rutas.MenuInicio.ruta){
            MenuInicio(navController = navController)
        }

        composable(Rutas.VerPadres.ruta){
            MenuPrincipal(navController = navController)
        }

        composable(Rutas.VerPadre.ruta){
            VerPadre(navController = navController)
        }
        composable(Rutas.VerHijo.ruta){
            VerHijo(navController = navController)
        }
        composable(Rutas.VerHijos.ruta){
            VerHijos(navController = navController)
        }

        composable(Rutas.OperacionesRealizar.ruta){
            OperacionesRealizar(navController = navController)
        }

    }
}



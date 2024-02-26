package com.example.aplicacionapi.Ventanas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practica3_joaopedrolimadias.Rutas

@Composable
fun MenuInicio(navController: NavController){
    Column {
        Text(text = "Bienvenidos a la app para ver informacion de Padres y Alumnos ")

        Text(text = "Dando en este boton veras a los padres")
        Button(onClick = { navController.navigate(Rutas.VerPadres.ruta) }, modifier = Modifier.width(130.dp).height(50.dp)) {
            Text(text = "Ver padres")
        }


        Text(text = "Dando en este boton veras a los hijos ")
        Button(onClick = { navController.navigate(Rutas.VerHijos.ruta)  }, modifier = Modifier.width(130.dp).height(50.dp)) {
            Text(text = "Ver hijos")
        }


        Text(text = "Dando en este boton podras filtrar ")
        Button(onClick = { /*TODO*/ }, modifier = Modifier.width(130.dp).height(50.dp)) {
            Text(text = "Filtros")
        }


        Text(text = "Operaciones")
        Button(onClick = { navController.navigate(Rutas.OperacionesRealizar.ruta)  }, modifier = Modifier.width(180.dp).height(50.dp)) {
            Text(text = "Ir a operaciones ")
        }
    }

}
package com.example.aplicacionapi.Ventanas

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apiparteandroid.Clases.Hijo
import com.example.apiparteandroid.Clases.Padre
import com.example.apiparteandroid.ViewModel.ViewModelApiFamilia
@Composable
fun subir(String: String){
    val viewModel : ViewModelApiFamilia = viewModel()
    var nombre by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var foto by remember { mutableStateOf("") }

    Column {
        Text(text = "Nombre del $String")
        TextField(value = nombre, onValueChange = { nombre = it })

        Text(text = "Apellidos del $String")
        TextField(value = apellidos, onValueChange = { apellidos = it })

        Text(text = "URL de imagen  del $String")
        TextField(value = foto, onValueChange = { foto = it })


        var hijo = Hijo( nombre, apellidos,foto )

        var padre = Padre( nombre, apellidos,foto )
        Button(onClick = {
            if (String.equals("padre")){
                viewModel.subirPadre(padre)
            }else if (String.equals("hijo")){
                viewModel.subirHijo(hijo)
            }
        }) {
            Text(text = "Subir")
        }
    }
}
@Composable
fun actualizar(String: String){
    val viewModel : ViewModelApiFamilia = viewModel()
    var nombre by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var foto by remember { mutableStateOf("") }

    Column {
        Text(text = "ID del  $String")
        TextField(value = id, onValueChange = { id = it })

        Text(text = "Nombre del $String")
        TextField(value = nombre, onValueChange = { nombre = it })

        Text(text = "Apellidos del $String")
        TextField(value = apellidos, onValueChange = { apellidos = it })

        Text(text = "URL de imagen  del $String")
        TextField(value = foto, onValueChange = { foto = it })


        var hijo = Hijo( nombre, apellidos,foto )

        var padre = Padre( nombre, apellidos,foto )
        Button(onClick = {
            if (String.equals("padre")){
                viewModel.actualizarPadre(id.toInt(),padre)
            }else if (String.equals("hijo")){
                viewModel.actualizarHijo(id.toInt(),hijo)
            }
        }) {
            Text(text = "Actualizar")
        }
    }
}
@Composable
fun borrar(String: String){
    val viewModel : ViewModelApiFamilia = viewModel()
    var id by remember { mutableStateOf("") }

    Column {
        Text(text = "ID del  $String")
        TextField(value = id, onValueChange = { id = it })

        Button(onClick = {
            if (String.equals("padre")){
                viewModel.borrarPadre(id.toInt())
            }else if (String.equals("hijo")){
                viewModel.borrarHijo(id.toInt())
            }
        }) {
            Text(text = "Borrar")
        }
    }
}
@Composable
fun subirHijoConPadre(String: String){
    val viewModel : ViewModelApiFamilia = viewModel()
    var nombre by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var foto by remember { mutableStateOf("") }
    Column {
        Text(text = "ID del Padre")
        TextField(value = id, onValueChange = { id = it })

        Text(text = "Nombre del $String")
        TextField(value = nombre, onValueChange = { nombre = it })

        Text(text = "Apellidos del $String")
        TextField(value = apellidos, onValueChange = { apellidos = it })

        Text(text = "URL de imagen  del $String")
        TextField(value = foto, onValueChange = { foto = it })


        var hijo = Hijo( nombre, apellidos,foto )

        Button(onClick = {
            viewModel.subirHijoConEnlace(id.toInt(),hijo)
        }) {
            Text(text = "Subir con enlace al Padre")
        }
    }
}
@Composable
fun enlazarHijoYPadre(){
    val viewModel : ViewModelApiFamilia = viewModel()
    var id by remember { mutableStateOf("") }
    var idPadre by remember { mutableStateOf("") }
    Column {
        Text(text = "ID del Hijo")
        TextField(value = id, onValueChange = { id = it })

        Text(text = "ID del Padre")
        TextField(value = idPadre, onValueChange = { idPadre = it })
        Button(onClick = {
            viewModel.enlazarHijoPadre(id.toInt(),idPadre.toInt())
        }) {
            Text(text = "Enlazar")
        }
    }
}
package com.example.aplicacionapi.Ventanas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.apiparteandroid.Clases.Root2
import com.example.apiparteandroid.ViewModel.ViewModelApiFamilia
import com.example.practica3_joaopedrolimadias.Rutas

@Composable
fun VerPadre(navController: NavController){
    val viewModel : ViewModelApiFamilia = viewModel()
    viewModel.obtenerHijos()
    val listaAmiibos = viewModel.listaHijos.collectAsState()
    var datos : State<MutableList<Root2>?> = listaAmiibos
    val listaActual: MutableList<Root2>? = datos.value
    Column(modifier  = Modifier.fillMaxSize()) {
        listaActual?.forEach {

            datos->
            if (datos.padre.padreId == Root2.valorIdPadre){
                AsyncImage(model = datos.padre.imagen, contentDescription = "")
                Text(text = "Nombre  : ${datos.padre.nombre}")
                Text(text = "Apellidos  : ${datos.padre.apellidos}")
                Text(text = "ID  : ${datos.padre.padreId}")

                datos.hijos.forEach{
                    hijos->
                    Box(modifier = Modifier.fillMaxWidth().clickable {
                        Root2.valorIdHijo = hijos.hijoId!!
                        navController.navigate(Rutas.VerHijo.ruta) }){
                        Row(modifier = Modifier.fillMaxWidth().height(100.dp),verticalAlignment = Alignment.CenterVertically) {
                            AsyncImage(model = hijos.imagen, contentDescription = null, modifier = Modifier.size(120.dp).clip(
                                CircleShape
                            ))
                            Column {
                                Text( "  Nombre :${hijos.nombre}")
                                Text( "  Apellidos  :${hijos.apellidos}")
                            }
                        }
                    }
                }
            }

        }
    }

}
package com.example.aplicacionapi.Ventanas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerHijos(navController: NavController){
    val viewModel : ViewModelApiFamilia = viewModel()
    viewModel.obtenerHijos()
    val listaAmiibos = viewModel.listaHijos.collectAsState()
    var textoSearchBar by remember { mutableStateOf("") }
    var activeSearchBar by remember { mutableStateOf(false) }
    var datos : State<MutableList<Root2>?> = listaAmiibos
    val listaActual: MutableList<Root2>? = datos.value
    Column {
        SearchBar(
            modifier = Modifier.fillMaxWidth(),
            query = textoSearchBar,
            onQueryChange = { textoSearchBar = it },
            onSearch = { activeSearchBar = false },
            active = activeSearchBar,
            onActiveChange = { activeSearchBar = it }){


        }
        Column() {
            listaActual?.forEach { root2 ->
                root2.hijos.forEach { hijo ->
                    Box(modifier = Modifier.fillMaxWidth().clickable {
                        Root2.valorIdHijo = hijo.hijoId!!
                        navController.navigate(Rutas.VerHijo.ruta) }){
                        Row(modifier = Modifier.fillMaxWidth().height(100.dp),verticalAlignment = Alignment.CenterVertically) {
                            AsyncImage(model = hijo.imagen, contentDescription = null, modifier = Modifier.size(120.dp).clip(
                                CircleShape
                            ))
                            Column {
                                Text( "  Nombre :${hijo.nombre}")
                                Text( "  Apellidos  :${hijo.apellidos}")
                            }
                        }
                    }
                }


            }
        }

    }
}
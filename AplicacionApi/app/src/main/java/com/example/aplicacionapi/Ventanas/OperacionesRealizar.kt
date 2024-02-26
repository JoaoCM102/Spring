package com.example.aplicacionapi.Ventanas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OperacionesRealizar(navController: NavController){
    var texto by remember { mutableStateOf("") }
    var expandir by remember { mutableStateOf(false) }

    var textoTipo by remember { mutableStateOf("") }
    var expandirTipo by remember { mutableStateOf(false) }
    Column {
        Row {
            Column {
                ExposedDropdownMenuBox(expanded = expandir, onExpandedChange = {expandir = !expandir} , modifier = Modifier.fillMaxWidth()) {
                    TextField(value = texto,
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor(),
                        label = { Text("Seleccionar opcion") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandir) }
                    )
                    DropdownMenu(expanded = expandir , onDismissRequest = { expandir = false }) {
                        DropdownMenuItem(modifier = Modifier.fillMaxWidth(),
                                text = { Text("Padre") },
                                onClick = { texto = "padre" }
                            )
                        DropdownMenuItem(modifier = Modifier.fillMaxWidth(),
                            text = { Text("Hijo") },
                            onClick = { texto = "hijo" }
                        )
                        }
                    }
                }
            }
            Column {
                ExposedDropdownMenuBox(expanded = expandirTipo, onExpandedChange = {expandirTipo = !expandirTipo} , modifier = Modifier.fillMaxWidth()) {
                    TextField(value = textoTipo,
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor(),
                        label = { Text("Seleccionar opcion") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandirTipo) }
                    )
                    DropdownMenu(expanded = expandirTipo , onDismissRequest = { expandirTipo = false }) {
                        DropdownMenuItem(modifier = Modifier.fillMaxWidth(),
                            text = { Text("Subir") },
                            onClick = { textoTipo = "subir" }
                        )
                        DropdownMenuItem(modifier = Modifier.fillMaxWidth(),
                            text = { Text("Editar") },
                            onClick = { textoTipo = "editar" }
                        )
                        DropdownMenuItem(modifier = Modifier.fillMaxWidth(),
                            text = { Text("Borrar") },
                            onClick = { textoTipo = "borrar" }
                        )
                        DropdownMenuItem(modifier = Modifier.fillMaxWidth(),
                            text = { Text("SubirHijoConIdPadre") },
                            onClick = { textoTipo = "subirHijoConIdPadre" }
                        )
                        DropdownMenuItem(modifier = Modifier.fillMaxWidth(),
                            text = { Text("Enlazar") },
                            onClick = { textoTipo = "enlazr" }
                        )
                    }
                }
            }
        Column {
            if (textoTipo.equals("subir")){
                subir(String = texto)
            }else if (textoTipo.equals("editar")){
                actualizar(String = texto)
            }else if (textoTipo.equals("borrar")){
                borrar(String = texto)
            }else if (textoTipo.equals("subirHijoConIdPadre")){
                subirHijoConPadre(String = texto)
            }else if (textoTipo.equals("enlazr")){
                enlazarHijoYPadre()
            }
        }
        }
    }

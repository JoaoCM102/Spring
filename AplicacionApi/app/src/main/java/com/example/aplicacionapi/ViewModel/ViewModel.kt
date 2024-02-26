package com.example.apiparteandroid.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiparteandroid.Clases.Hijo
import com.example.apiparteandroid.Clases.Padre
import com.example.apiparteandroid.Clases.Root
import com.example.apiparteandroid.Clases.Root2
import com.example.apiparteandroid.Interface.FamiliaApi.retrofitService
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

enum class estadoApi{
    IDLE, LOADING, SUCCESS, ERROR
}

class ViewModelApiFamilia : ViewModel(){
    var _listaHijos : MutableStateFlow<MutableList<Root2>?> = MutableStateFlow(null)
    var listaHijos = _listaHijos.asStateFlow()

    private val _estadoLlamada : MutableStateFlow<estadoApi> = MutableStateFlow(estadoApi.IDLE)
    var estadoLlamada = _estadoLlamada.asStateFlow()

    init {
        obtenerHijos()
    }

    fun obtenerHijos() {
        _estadoLlamada.value = estadoApi.LOADING
        viewModelScope.launch {
            try {
                val respuesta = retrofitService.getAll()

                    val listaMutable: MutableList<Root2>? = respuesta.body()?.toMutableList()
                    _listaHijos.value = listaMutable
                    _estadoLlamada.value = estadoApi.SUCCESS
                    println("Lista de hijos obtenida exitosamente:")
            } catch (e: Exception) {
                println("Ha ocurrido una excepción: $e")
            }
        }
    }
    fun subirHijo(hijo: Hijo){
        _estadoLlamada.value = estadoApi.LOADING
        viewModelScope.launch {
            try {
                val respuesta = retrofitService.subirHijo(hijo)
                _estadoLlamada.value = estadoApi.SUCCESS
            } catch (e: Exception) {
                println("Ha ocurrido una excepción: $e")
            }
        }
    }
    fun subirHijoConEnlace(int: Int,hijo: Hijo){
        _estadoLlamada.value = estadoApi.LOADING
        viewModelScope.launch {
            try {
                val respuesta = retrofitService.subirHijoConEnlace(int,hijo)
                _estadoLlamada.value = estadoApi.SUCCESS
            } catch (e: Exception) {
                println("Ha ocurrido una excepción: $e")
            }
        }
    }
    fun subirPadre(padre: Padre){
        _estadoLlamada.value = estadoApi.LOADING
        viewModelScope.launch {
            try {
                val respuesta = retrofitService.subirPadre(padre)
                _estadoLlamada.value = estadoApi.SUCCESS
            } catch (e: Exception) {
                println("Ha ocurrido una excepción: $e")
            }
        }
    }
    fun borrarHijo(int: Int){
        _estadoLlamada.value = estadoApi.LOADING
        viewModelScope.launch {
            try {
                val respuesta = retrofitService.borrarHijo(int)
                _estadoLlamada.value = estadoApi.SUCCESS
            } catch (e: Exception) {
                println("Ha ocurrido una excepción: $e")
            }
        }
    }
    fun borrarPadre(int: Int){
        _estadoLlamada.value = estadoApi.LOADING
        viewModelScope.launch {
            try {
                val respuesta = retrofitService.borrarPadre(int)
                _estadoLlamada.value = estadoApi.SUCCESS
            } catch (e: Exception) {
                println("Ha ocurrido una excepción: $e")
            }
        }
    }
    fun actualizarPadre(int: Int,padre: Padre){
        _estadoLlamada.value = estadoApi.LOADING
        viewModelScope.launch {
            try {
                val respuesta = retrofitService.actualizarPadre(int,padre)
                _estadoLlamada.value = estadoApi.SUCCESS
            } catch (e: Exception) {
                println("Ha ocurrido una excepción: $e")
            }
        }
    }
    fun actualizarHijo(int: Int,hijo: Hijo){
        _estadoLlamada.value = estadoApi.LOADING
        viewModelScope.launch {
            try {
                val respuesta = retrofitService.actualizarHijo(int,hijo)
                _estadoLlamada.value = estadoApi.SUCCESS
            } catch (e: Exception) {
                println("Ha ocurrido una excepción: $e")
            }
        }
    }
    fun enlazarHijoPadre(int: Int,idPadre : Int){
        _estadoLlamada.value = estadoApi.LOADING
        viewModelScope.launch {
            try {
                val respuesta = retrofitService.enlazarHijoConPadre(int,idPadre)
                _estadoLlamada.value = estadoApi.SUCCESS
            } catch (e: Exception) {
                println("Ha ocurrido una excepción: $e")
            }
        }
    }




}


package com.example.apiparteandroid.Interface

import com.example.apiparteandroid.Clases.Hijo
import com.example.apiparteandroid.Clases.Padre
import com.example.apiparteandroid.Clases.Root
import com.example.apiparteandroid.Clases.Root2
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

private const val BASE_URL =
    "http://192.168.18.3:8080"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

object FamiliaApi {
    val retrofitService: Api by lazy {
        retrofit.create(Api::class.java)
    }
}

interface Api {
    @GET("/")
    @Headers("Accept: Application/json")
    suspend fun getAll(): Response<List<Root2>>

    @PUT("/hijos/{id}")
    @Headers("Accept: Application/json")
    suspend fun actualizarHijo(@Path("id") id: Int, @Body hijo: Hijo): Response<Void>

    @PUT("/hijos/{id}/Con/{idPadre}")
    @Headers("Accept: Application/json")
    suspend fun enlazarHijoConPadre(@Path("id") id: Int, @Path("idPadre") idPadre : Int): Response<Void>

    @POST("/hijos")
    @Headers("Accept: Application/json")
    suspend fun subirHijo(@Body hijo: Hijo): Response<Void>

    @POST("hijo/SubirHijoConEnlacePadre/{id}")
    @Headers("Accept: Application/json")
    suspend fun subirHijoConEnlace(@Path("id") id : Int,@Body hijo: Hijo): Response <Void>

    @DELETE("/hijos/{id}")
    @Headers("Accept: Application/json")
    suspend fun borrarHijo(@Path("id") id : Int): Response <Void>

    @POST("/padres")
    @Headers("Accept: Application/json")
    suspend fun subirPadre(@Body padre: Padre): Response<Void>

    @PUT("/padres/{id}")
    @Headers("Accept: Application/json")
    suspend fun actualizarPadre(@Path("id") id: Int, @Body padre: Padre): Response<Void>

    @DELETE("/padres/{id}")
    @Headers("Accept: Application/json")
    suspend fun borrarPadre(@Path("id") id : Int): Response <Void>

}

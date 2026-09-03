package com.example.segundaappsqlite.ejemplo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuarioDao {

    //Inserta un nuevo usuario en la tabla
    @Insert
    suspend fun insertar(usuario: Usuario)

    //Consulta todos los usuarios ordenados por ID
    @Query("SELECT * FROM tabla_usuarios ORDER BY id ASC")
    suspend fun obtenerTodos(): List<Usuario>
}
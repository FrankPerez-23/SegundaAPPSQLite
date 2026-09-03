package com.example.segundaappsqlite.ejercicio1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductoDao {

    @Insert
    suspend fun insertar(producto: Producto)

    @Query("SELECT * FROM tabla_productos ORDER BY id ASC")
    suspend fun obtenerTodos(): List<Producto>
}
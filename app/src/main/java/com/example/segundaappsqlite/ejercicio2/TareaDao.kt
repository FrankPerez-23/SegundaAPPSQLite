package com.example.segundaappsqlite.ejercicio2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.segundaappsqlite.ejercicio1.Producto

@Dao
interface TareaDao {
    @Insert
    suspend fun insertar(tarea: Tarea)

    @Query("SELECT * FROM tabla_tareas WHERE esCompletada = 0 ")
    suspend fun obtenerPendientes(): List<Tarea>
}
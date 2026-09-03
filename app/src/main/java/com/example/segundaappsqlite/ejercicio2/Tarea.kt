package com.example.segundaappsqlite.ejercicio2

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("tabla_tareas")
data class Tarea(
    @PrimaryKey(true)
    val id: Int = 0,
    val titulo: String,
    val esCompletada: Boolean
)

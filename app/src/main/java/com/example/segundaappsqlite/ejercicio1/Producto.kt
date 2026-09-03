package com.example.segundaappsqlite.ejercicio1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("tabla_productos")
data class Producto(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val precio: Double = 0.0,
    val stock: Int = 0
)

package com.example.segundaappsqlite.ejercicio2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.segundaappsqlite.R
import kotlinx.coroutines.launch

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        //1. Obtener la instancia de la base de datos
        val db = AppDatabase_Tarea.getDatabase(this)
        val dao = db.tareaDao()

        //2. Ejecutar inserción y lectura en segundo plano usando corrutinas
        lifecycleScope.launch{
            //Crear e insertar un usuario
            val nuevaTarea1 = Tarea(titulo = "Lunes", esCompletada = true)
            val nuevaTarea2 = Tarea(titulo = "Martes", esCompletada = true)
            val nuevaTarea3 = Tarea(titulo = "Miercoles", esCompletada = false)
            val nuevaTarea4 = Tarea(titulo = "Jueves", esCompletada = false)

            dao.insertar(nuevaTarea1)
            dao.insertar(nuevaTarea2)
            dao.insertar(nuevaTarea3)
            dao.insertar(nuevaTarea4)

            //Consultar la lista completa
            val listaTareas = dao.obtenerPendientes()

            //Imprimir en la consola(Logcat)
            for(u in listaTareas){
                Log.d("EJERCICIO_2","ID: ${u.titulo} | Nombre: ${u.esCompletada}")
            }
        }
    }
}
package com.example.segundaappsqlite.ejemplo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.segundaappsqlite.R
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1. Obtener la instancia de la base de datos
        val db = AppDatabase.getDatabase(this)
        val dao = db.usuarioDao()

        //2. Ejecutar inserción y lectura en segundo plano usando corrutinas
        lifecycleScope.launch{
            //Crear e insertar un usuario
            val nuevoUsuario = Usuario(nombre="Carlos", edad = 20)
            dao.insertar(nuevoUsuario)

            //Consultar la lista completa
            val listaUsuarios = dao.obtenerTodos()

            //Imprimir en la consola(Logcat)
            for(u in listaUsuarios){
                Log.d("ROOM_DEMO","ID: ${u.id} | Nombre: ${u.nombre} | Edad: ${u.edad}")
            }
        }
    }
}
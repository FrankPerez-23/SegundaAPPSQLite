package com.example.segundaappsqlite.ejercicio1

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.segundaappsqlite.R
import com.example.segundaappsqlite.ejemplo.AppDatabase
import com.example.segundaappsqlite.ejemplo.Usuario
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //1. Obtener la instancia de la base de datos
        val db = AppDatabase_Producto.getDatabase(this)
        val dao = db.productoDao()

        //2. Ejecutar inserción y lectura en segundo plano usando corrutinas
        lifecycleScope.launch{
            //Crear e insertar un usuario
            val nuevoProducto1 = Producto(nombre = "Laptop", precio = 2499.0, stock = 50)
            val nuevoProducto2 = Producto(nombre = "Mouse", precio = 142.0, stock = 50)
            val nuevoProducto3 = Producto(nombre = "Teclado", precio = 185.0 , stock = 50)

            dao.insertar(nuevoProducto1)
            dao.insertar(nuevoProducto2)
            dao.insertar(nuevoProducto3)

            //Consultar la lista completa
            val listaProductos = dao.obtenerTodos()

            //Imprimir en la consola(Logcat)
            for(u in listaProductos){
                Log.d("EJERCICIO_1","ID: ${u.id} | Nombre: ${u.nombre} | Precio: ${u.precio} | Stock: ${u.stock}")
            }
        }
    }
}
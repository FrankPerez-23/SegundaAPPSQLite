package com.example.segundaappsqlite.ejercicio1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.segundaappsqlite.ejemplo.AppDatabase

@Database(entities=[Producto::class],version=1,exportSchema = false)
abstract class AppDatabase_Producto : RoomDatabase(){

    abstract fun productoDao(): ProductoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase_Producto? = null

        fun getDatabase(context: Context): AppDatabase_Producto{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase_Producto::class.java,
                    "productos_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
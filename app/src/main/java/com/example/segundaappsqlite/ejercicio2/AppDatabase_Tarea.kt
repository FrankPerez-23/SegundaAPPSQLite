package com.example.segundaappsqlite.ejercicio2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.segundaappsqlite.ejercicio1.AppDatabase_Producto


@Database(entities=[Tarea::class],version=1,exportSchema = false)
abstract class AppDatabase_Tarea : RoomDatabase(){
    abstract fun tareaDao(): TareaDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase_Tarea? = null

        fun getDatabase(context: Context): AppDatabase_Tarea{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase_Tarea::class.java,
                    "tareas_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
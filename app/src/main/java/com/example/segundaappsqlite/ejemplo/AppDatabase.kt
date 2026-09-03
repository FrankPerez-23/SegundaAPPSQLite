package com.example.segundaappsqlite.ejemplo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities=[Usuario::class],version=1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun usuarioDao(): UsuarioDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        //Garantiza una unica instancia de la base de datos(Singleton)
        fun getDatabase(context: Context): AppDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "usuarios_database" //Nombre del archivo SQLite
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
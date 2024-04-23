package ru.android.petwatch.repositories

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.android.petwatch.dao.AnimalDao
import ru.android.petwatch.model.Animal

private const val TAG = "ROOM_APP_DTB"
@Database(entities = [Animal::class], version = 1)
abstract class RoomAppDtb : RoomDatabase() {

    abstract fun animalDao(): AnimalDao

    companion object {
        @Volatile
        private var INSTANCE: RoomAppDtb? = null
        fun getAppDatabase(context: Context): RoomAppDtb {
            Log.d(TAG, "mt getAppDataBase")
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context, RoomAppDtb::class.java, "AppDTB"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
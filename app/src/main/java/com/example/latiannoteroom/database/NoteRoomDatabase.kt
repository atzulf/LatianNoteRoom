package com.example.latiannoteroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class NoteRoomDatabase : RoomDatabase() {
    abstract fun NoteDao(): NoteDao

    companion object {
        @Volatile
        private var instance: NoteRoomDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): NoteRoomDatabase {
            if (instance == null) {
                synchronized(NoteRoomDatabase::class.java) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteRoomDatabase::class.java, "note_database"
                    ).build()
                }
            }
            return instance as NoteRoomDatabase
        }
    }

}
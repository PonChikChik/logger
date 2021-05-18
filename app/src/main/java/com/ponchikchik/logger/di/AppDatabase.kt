package com.ponchikchik.logger.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
//import com.ponchikchik.logger.di.dao.LogDao
//import com.ponchikchik.logger.di.model.LogEntry
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

//@Database(entities = [LogEntry::class], version = 1)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun logDao(): LogDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//        const val DATABASE_NAME = "logs"
//
//        @InternalCoroutinesApi
//        fun getDatabase(applicationContext: Context): AppDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    applicationContext,
//                    AppDatabase::class.java,
//                    DATABASE_NAME
//                ).build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
//}
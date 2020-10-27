package com.gebeya.fetan.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gebeya.fetan.data.model.Run
import com.gebeya.fetan.data.model.RunDao

@Database(entities = [Run::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun runDao() : RunDao
}
package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.datasource.CourseDao
import com.example.data.model.CourseEntity

@Database(entities = [CourseEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao
}
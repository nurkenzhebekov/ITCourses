package com.example.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.model.CourseEntity

@Dao
interface CourseDao {
    @Query("SELECT * FROM courses")
    fun getCourses(): List<CourseEntity>

    @Insert
    suspend fun addToFavorites(course: CourseEntity)
}
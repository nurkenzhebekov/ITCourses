package com.example.domain.repository

import com.example.domain.model.Course
import kotlinx.coroutines.flow.Flow

interface CourseRepository {
    fun getCourses(): Flow<List<Course>>
    fun getCourseDetails(courseId: Int): Flow<Course?>
    suspend fun addToFavorites(course: Course)
    suspend fun removeFromFavorites(courseId: Int)
    fun getFavoriteCourses(): Flow<List<Course>>
}
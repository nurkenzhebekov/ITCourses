package com.example.data.repository

import com.example.data.datasource.CourseApi
import com.example.data.datasource.CourseDao
import com.example.data.mapper.toDomain
import com.example.data.mapper.toEntity
import com.example.domain.model.Course
import com.example.domain.repository.CourseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CourseRepositoryImpl @Inject constructor(
    private val api: CourseApi,
    private val dao: CourseDao
) : CourseRepository {
    override fun getCourses(): Flow<List<Course>> = flow {
        val courses = api.getCourses().map { it.toDomain() }
        emit(courses)
    }

    override fun getCourseDetails(courseId: Int): Flow<Course> = flow {
        val course = dao.getCourses().find { it.id == courseId }?.toDomain()
        course?.let { emit(it)}
    }

    override suspend fun addToFavorites(course: Course) {
        dao.addToFavorites(course.toEntity())
    }

    override suspend fun removeFromFavorites(courseId: Int) {
        TODO("Not yet implemented")
    }

    override fun getFavoriteCourses(): Flow<List<Course>> = flow {
        val favorites = dao.getCourses().map { it.toDomain() }
        emit(favorites)
    }
}
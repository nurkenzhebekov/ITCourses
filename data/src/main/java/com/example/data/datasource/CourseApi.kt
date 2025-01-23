package com.example.data.datasource

import com.example.data.model.CourseDto
import retrofit2.http.GET

interface CourseApi {
    @GET("courses")
    suspend fun getCourses(): List<CourseDto>
}
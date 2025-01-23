package com.example.data.mapper

import com.example.data.model.CourseDto
import com.example.data.model.CourseEntity
import com.example.domain.model.Course

fun CourseDto.toDomain() = Course(id, name, description, price, rating, dateAdded)

fun CourseEntity.toDomain() = Course(id, name, description, price, rating, dateAdded)

fun Course.toEntity() = CourseEntity(id, name, description, price, rating, dateAdded)
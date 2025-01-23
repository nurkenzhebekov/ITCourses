package com.example.domain.model

data class Course(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val rating: Float,
    val dateAdded: String
)

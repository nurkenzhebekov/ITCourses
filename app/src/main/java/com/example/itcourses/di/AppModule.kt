package com.example.itcourses.di

import com.example.data.repository.CourseRepositoryImpl
import com.example.domain.repository.CourseRepository
import com.example.domain.usecase.GetCoursesUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGetCoursesUseCase(repository: CourseRepository): GetCoursesUseCase {
        return GetCoursesUseCase(repository)
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCourseRepository(
        courseRepositoryImpl: CourseRepositoryImpl
    ): CourseRepository
}
package com.example.demoappmovies.domain

import com.example.demoappmovies.data.model.MovieList

interface MovieRepository {
    suspend fun getUpcomingMovies(): MovieList
    suspend fun getTopRatedMovies(): MovieList
    suspend fun getPopularMovies(): MovieList


}
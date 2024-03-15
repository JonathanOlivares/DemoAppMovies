package com.example.demoappmovies.data.local

import com.example.demoappmovies.application.AppConstants
import com.example.demoappmovies.data.model.Movie
import com.example.demoappmovies.data.model.MovieEntity
import com.example.demoappmovies.data.model.MovieList
import com.example.demoappmovies.data.model.toMovieList

class LocalMovieDataSource(private val movieDao: MovieDao) {
    suspend fun getUpComingMovies(): MovieList{
        return movieDao.getAllMovies().filter { it.movie_type == "upcoming" }.toMovieList()
    }
    suspend fun getTopRatedMovies(): MovieList {
        return movieDao.getAllMovies().filter { it.movie_type == "toprated" }.toMovieList()
    }
    suspend fun getPopularMovies(): MovieList{
        return movieDao.getAllMovies().filter { it.movie_type == "popular" }.toMovieList()
    }

    suspend fun saveMovie(movie: MovieEntity){
        movieDao.saveMovie(movie)
    }
}
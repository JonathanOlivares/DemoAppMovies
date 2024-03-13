package com.example.demoappmovies.repository

import com.example.demoappmovies.data.model.MovieList
import com.example.demoappmovies.data.model.TvSeriesList

interface MovieRepository {
    suspend fun getNowPlayingMovies(): MovieList
    suspend fun getUpComingMovies(): MovieList
    suspend fun getTopRatedMovies(): MovieList
    suspend fun getPopularMovies(): MovieList

    //Tv
    suspend fun getAiringTodayTv(): TvSeriesList
    suspend fun getOnTheAirTv(): TvSeriesList
    suspend fun getPopularTv(): TvSeriesList
    suspend fun getTopRatedTv(): TvSeriesList

}
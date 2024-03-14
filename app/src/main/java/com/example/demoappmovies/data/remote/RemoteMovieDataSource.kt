package com.example.demoappmovies.data.remote

import com.example.demoappmovies.application.AppConstants
import com.example.demoappmovies.data.model.MovieList
import com.example.demoappmovies.data.model.TvSeriesList
import com.example.demoappmovies.repository.WebService

//Despues de crear el modelo se venimos al DataSource que es el lugar a donde iremos a buscar la información que necesitamos y creamos 3
//metodos, simplemente anotando lo que necesitamos traer, la listas getUpcoming,getTopRated y getPopular, retornando así una lista de peliculas.

class RemoteMovieDataSource(private val webService: WebService) {

    suspend fun getNowPlayingMovies() : MovieList = webService.getNowPlayingMovies(AppConstants.API_KEY)

    suspend fun getUpComingMovies(): MovieList = webService.getUpComingMovies(AppConstants.API_KEY)

    suspend fun getTopRatedMovies(): MovieList = webService.getTopRatedMovies(AppConstants.API_KEY)

    suspend fun getPopularMovies(): MovieList = webService.getPopularMovies(AppConstants.API_KEY)

    //Tv

    suspend fun getAiringTodayTv(): TvSeriesList = webService.getAiringTodayTv(AppConstants.API_KEY)

    suspend fun getOnTheAirTv(): TvSeriesList = webService.getOnTheAirTv(AppConstants.API_KEY)

    suspend fun getPopularTv(): TvSeriesList = webService.getPopularTv(AppConstants.API_KEY)

    suspend fun getTopRatedTv(): TvSeriesList = webService.getTopRatedTv(AppConstants.API_KEY)
}
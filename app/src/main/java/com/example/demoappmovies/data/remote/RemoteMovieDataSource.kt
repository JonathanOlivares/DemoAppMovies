package com.example.demoappmovies.data.remote

import com.example.demoappmovies.application.AppConstants
import com.example.demoappmovies.data.model.MovieList
import com.example.demoappmovies.domain.WebService

//Despues de crear el modelo se venimos al DataSource que es el lugar a donde iremos a buscar la información que necesitamos y creamos 3
//metodos, simplemente anotando lo que necesitamos traer, la listas getUpcoming,getTopRated y getPopular, retornando así una lista de peliculas.

class RemoteMovieDataSource(private val webService: WebService) {

    suspend fun getUpComingMovies(): MovieList = webService.getUpComingMovies(AppConstants.API_KEY)

    suspend fun getTopRatedMovies(): MovieList = webService.getTopRatedMovies(AppConstants.API_KEY)

    suspend fun getPopularMovies(): MovieList = webService.getPopularMovies(AppConstants.API_KEY)


}
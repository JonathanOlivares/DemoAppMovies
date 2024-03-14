package com.example.demoappmovies.repository

import com.example.demoappmovies.data.model.MovieList
import com.example.demoappmovies.data.model.TvSeriesList
import com.example.demoappmovies.data.remote.RemoteMovieDataSource

//Creamos una instancia del datasource aquí dentro para poder acceder a los metodos
//para eso creamos una instancia dentro del constructor del repositorio llamado dataSource.
//Por lo tanto lo unico que se hace es enlazar una clase con otra y creando una cadena entre las distintas clases.

class MovieRepositoryImpl(private val dataSourceRemote: RemoteMovieDataSource): MovieRepository {

    //El datasource nos es lo mismo que poner return, sólo se puede hacer así en kotlin

    override suspend fun getNowPlayingMovies(): MovieList = dataSourceRemote.getNowPlayingMovies()

    override suspend fun getUpComingMovies(): MovieList = dataSourceRemote.getUpComingMovies()

    override suspend fun getTopRatedMovies(): MovieList = dataSourceRemote.getTopRatedMovies()

    override suspend fun getPopularMovies(): MovieList = dataSourceRemote.getPopularMovies()

    //Tv

    override suspend fun getAiringTodayTv(): TvSeriesList = dataSourceRemote.getAiringTodayTv()

    override suspend fun getOnTheAirTv(): TvSeriesList = dataSourceRemote.getOnTheAirTv()

    override suspend fun getPopularTv(): TvSeriesList = dataSourceRemote.getPopularTv()

    override suspend fun getTopRatedTv(): TvSeriesList = dataSourceRemote.getTopRatedTv()

}
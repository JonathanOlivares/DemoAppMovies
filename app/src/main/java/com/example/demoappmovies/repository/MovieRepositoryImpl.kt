package com.example.demoappmovies.repository

import com.example.demoappmovies.data.model.MovieList
import com.example.demoappmovies.data.model.TvSeriesList
import com.example.demoappmovies.data.remote.MovieDataSource

//Creamos una instancia del datasource aquí dentro para poder acceder a los metodos
//para eso creamos una instancia dentro del constructor del repositorio llamado dataSource.
//Por lo tanto lo unico que se hace es enlazar una clase con otra y creando una cadena entre las distintas clases.

class MovieRepositoryImpl(private val dataSource: MovieDataSource): MovieRepository {

    //El datasource nos es lo mismo que poner return, sólo se puede hacer así en kotlin

    override suspend fun getNowPlayingMovies(): MovieList = dataSource.getNowPlayingMovies()

    override suspend fun getUpComingMovies(): MovieList = dataSource.getUpComingMovies()

    override suspend fun getTopRatedMovies(): MovieList = dataSource.getUpRatedMovies()

    override suspend fun getPopularMovies(): MovieList = dataSource.getPopularMovies()

    //Tv

    override suspend fun getAiringTodayTv(): TvSeriesList = dataSource.getAiringTodayTv()

    override suspend fun getOnTheAirTv(): TvSeriesList = dataSource.getOnTheAirTv()

    override suspend fun getPopularTv(): TvSeriesList = dataSource.getPopularTv()

    override suspend fun getTopRatedTv(): TvSeriesList = dataSource.getTopRatedTv()

}
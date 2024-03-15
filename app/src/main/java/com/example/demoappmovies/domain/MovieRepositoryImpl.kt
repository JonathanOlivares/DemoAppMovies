package com.example.demoappmovies.domain

import com.example.demoappmovies.core.InternetCheck
import com.example.demoappmovies.data.local.LocalMovieDataSource
import com.example.demoappmovies.data.model.MovieList
import com.example.demoappmovies.data.model.toMovieEntity
import com.example.demoappmovies.data.remote.RemoteMovieDataSource

//Creamos una instancia del datasource aquí dentro para poder acceder a los metodos
//para eso creamos una instancia dentro del constructor del repositorio llamado dataSource.
//Por lo tanto lo unico que se hace es enlazar una clase con otra y creando una cadena entre las distintas clases.

class MovieRepositoryImpl(
    private val dataSourceRemote: RemoteMovieDataSource,
    private val dataSourceLocal: LocalMovieDataSource
) : MovieRepository {

    //El datasource nos es lo mismo que poner return, sólo se puede hacer así en kotlin

    override suspend fun getUpcomingMovies(): MovieList {
        return if (InternetCheck.isNetworkAvailable()) {
            dataSourceRemote.getUpComingMovies().results.forEach { movie ->
                dataSourceLocal.saveMovie(movie.toMovieEntity("upcoming"))
            }
            return dataSourceLocal.getUpComingMovies()
        } else {
            dataSourceLocal.getUpComingMovies()
        }
    }

    override suspend fun getTopRatedMovies(): MovieList {
        return if (InternetCheck.isNetworkAvailable()) {
            dataSourceRemote.getTopRatedMovies().results.forEach { movie ->
                dataSourceLocal.saveMovie(movie.toMovieEntity("toprated"))
            }
            return dataSourceLocal.getTopRatedMovies()
        } else {
            dataSourceLocal.getTopRatedMovies()
        }
    }

    override suspend fun getPopularMovies(): MovieList {
        return if (InternetCheck.isNetworkAvailable()) {
        dataSourceRemote.getPopularMovies().results.forEach { movie ->
            dataSourceLocal.saveMovie(movie.toMovieEntity("popular"))
        }
        return dataSourceLocal.getPopularMovies()
    }else{
        dataSourceLocal.getPopularMovies()
        }
    }

}
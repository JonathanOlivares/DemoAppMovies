package com.example.demoappmovies.repository

import com.example.demoappmovies.application.AppConstants
import com.example.demoappmovies.data.model.MovieList
import com.example.demoappmovies.data.model.TvSeriesList
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(@Query("api_key")apiKey: String): MovieList

    @GET("movie/upcoming")
    suspend fun getUpComingMovies(@Query("api_key") apiKey: String): MovieList

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("api_key")apiKey: String): MovieList

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")apiKey: String): MovieList

    //Tv

    @GET("tv/airing_today")
    suspend fun getAiringTodayTv(@Query("api_key")apiKey: String): TvSeriesList

    @GET("tv/on_the_air")
    suspend fun getOnTheAirTv(@Query("api_key")apiKey: String): TvSeriesList

    @GET("tv/popular")
    suspend fun getPopularTv(@Query("api_key")apiKey: String): TvSeriesList

    @GET("tv/top_rated")
    suspend fun getTopRatedTv(@Query("api_key")apiKey: String): TvSeriesList
}

object RetrofitClient{

    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}
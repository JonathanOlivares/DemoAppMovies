package com.example.demoappmovies.data.model

data class TvSerie (
    val id: Int = -1,
    val adult: Boolean = false,
    val genre_ids: List<Int> = listOf(),
    val origin_country: String = "",
    val backdrop_path: String = "",
    val original_name: String = "",
    val original_language: String ="",
    val overview: String = "",
    val popularity: Double = -1.0,
    val poster_path: String = "",
    val first_air_date: String ="",
    val name: String = "",
    val vote_average: Double = -1.0,
    val vote_count: Int = -1
)

data class TvSeriesList (val results: List<TvSerie> = listOf())
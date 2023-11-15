package com.ninoleliege.mmi.myapplication

data class TmdbMovieResult(
    val page: Int = 0,
    val results: List<TmdbMovie> = listOf()
)

data class TmdbMovie(
    val backdrop_path: String = "",
    val genre_ids: List<Int> = listOf(),
    val id: Int = 0,
    val original_title: String = "",
    val overview: String = "",
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = ""
)
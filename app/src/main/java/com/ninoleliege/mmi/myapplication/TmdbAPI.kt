package com.ninoleliege.mmi.myapplication

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    // liste des films
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") api_key: String): TmdbMovieResult


    // liste des series
    @GET("trending/tv/week")
    suspend fun lastseries(@Query("api_key") api_key: String): TmdbTvResult


    // detail d'un film
    @GET("movie/{id}?append_to_response=credits")
    suspend fun detailsfilm(@Path("id") id: String, @Query("api_key") api_key: String): TmdbDetailsFilm

    // detail d'une serie
    @GET("tv/{id}?append_to_response=credits")
    suspend fun detailsserie(@Path("id") id: String, @Query("api_key") api_key: String): TmdbDetailsTv


    // liste des acteurs
    @GET("trending/person/week")
    suspend fun lastacteurs(@Query("api_key") api_key: String): TmdbPersonResult
}
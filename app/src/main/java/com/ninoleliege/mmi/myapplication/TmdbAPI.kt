package com.ninoleliege.mmi.myapplication

import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("432dbeb947fe645d6b008204074295c6") api_key: String): TmdbMovieResult
}
package com.ninoleliege.mmi.myapplication

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {


    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build();

    val api = retrofit.create(Api::class.java)

    val movies = MutableStateFlow<List<TmdbMovie>>(listOf())

    fun getMovies() {
        viewModelScope.launch {
            movies.value = api.lastmovies("432dbeb947fe645d6b008204074295c6").results
        }
    }

    val series = MutableStateFlow<List<TmdbTv>>(listOf())

    fun getSeries() {
        viewModelScope.launch {
            series.value = api.lastseries("432dbeb947fe645d6b008204074295c6").results
        }
    }


    val detailsfilm = MutableStateFlow<TmdbDetailsFilm?>(null)

    fun getDetailsFilm(id:String) {
        viewModelScope.launch {
            detailsfilm.value = api.detailsfilm(api_key = "432dbeb947fe645d6b008204074295c6", id=id)
        }
    }

    val detailsserie = MutableStateFlow<TmdbDetailsTv?>(null)

    fun getDetailsSerie(id:String) {
        viewModelScope.launch {
            detailsserie.value = api.detailsserie(api_key = "432dbeb947fe645d6b008204074295c6", id=id)
        }
    }

    val acteurs = MutableStateFlow<List<TmdbPerson>>(listOf())

    fun getActeurs() {
        viewModelScope.launch {
            acteurs.value = api.lastacteurs("432dbeb947fe645d6b008204074295c6").results
        }
    }

}



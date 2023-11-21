package com.ninoleliege.mmi.myapplication

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import androidx.compose.foundation.lazy.grid.items

@Composable
fun ListeDetailsFilm(viewModel: MainViewModel, id:String){
    LaunchedEffect(key1 = 0){viewModel.getDetailsFilm(id)}
    val details by viewModel.detailsfilm.collectAsStateWithLifecycle()

    val idimage = "https://image.tmdb.org/t/p/w400/" + details?.poster_path
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly) {
        AsyncImage(
            model = idimage,
            contentDescription = details?.original_title,

            )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = details?.original_title?:"pas de titre")
            Text(text = details?.release_date?:"pas de date")

        }
    }



    LazyVerticalGrid(columns = GridCells.Fixed(1), horizontalArrangement = Arrangement.spacedBy(16.dp), verticalArrangement = Arrangement.spacedBy(20.dp) ){
        item{
            //liste des acteurs
        }
    }
}

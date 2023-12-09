package com.ninoleliege.mmi.myapplication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage

@Composable
fun ListeSeries(viewModel: MainViewModel, onClick:(id:String)->Unit){
    LaunchedEffect(key1 = 0){viewModel.getSeries()}
    val series by viewModel.series.collectAsStateWithLifecycle()

    LazyVerticalGrid(columns = GridCells.Fixed(2), horizontalArrangement = Arrangement.spacedBy(16.dp), verticalArrangement = Arrangement.spacedBy(20.dp) ){
        for (serie in series){
            items(1) {
                Column(modifier = Modifier.fillMaxSize().clickable{onClick(serie.id.toString())}, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, ) {

                    val idimage = "https://image.tmdb.org/t/p/w780/" + serie.poster_path
                    AsyncImage(
                        model = idimage,
                        contentDescription = serie.original_name,
                    )
                    Text(text = serie.original_name)
                    Text(text = serie.first_air_date)
                }
            }
        }
    }

}
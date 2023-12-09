package com.ninoleliege.mmi.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage

@Composable
fun ListeDetailsSeries(viewModel: MainViewModel, id:String) {
    LaunchedEffect(key1 = 0) { viewModel.getDetailsSerie(id) }
    val details by viewModel.detailsfilm.collectAsStateWithLifecycle()

    val idimage = "https://image.tmdb.org/t/p/w500/" + details?.poster_path
    val idimagefond = "https://image.tmdb.org/t/p/w1280/" + details?.backdrop_path
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        AsyncImage(
            model = idimagefond,
            contentDescription = details?.original_title,
        )
        AsyncImage(
            model = idimage,
            contentDescription = details?.original_title,
        )

        Text(text = details?.original_title ?: "pas de titre")
        Text(text = details?.release_date ?: "pas de date")
        Text(text = (details?.vote_average.toString() + "/10") ?: "pas de note")
        Text(text = details?.overview ?: "pas de description")

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = "Distribution",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            // Liste des acteurs
            details?.credits?.cast?.forEach { actor ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Image de l'acteur
                    AsyncImage(
                        model = "https://image.tmdb.org/t/p/w200/${actor.profile_path}",
                        contentDescription = actor.original_name,
                        modifier = Modifier
                            .width(80.dp)
                            .height(80.dp)
                    )

                    // Informations sur l'acteur
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Text(text = actor.original_name ?: "Nom inconnu")
                        Text(text = "Personnage: ${actor.character ?: "Personnage inconnu"}")
                    }
                }
            }
        }

    }
}



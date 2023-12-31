package com.ninoleliege.mmi.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ninoleliege.mmi.myapplication.ui.theme.MyApplicationTheme
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


sealed class Destination(val destination: String, val label: String, val icon: ImageVector) {
    object Profil : Destination("profil", "Mon Profil", Icons.Filled.Person)
    object Films : Destination("films", "liste des films", Icons.Filled.Edit)
    object Series : Destination("series", "liste des series", Icons.Filled.Edit)
    object Acteurs : Destination("acteurs", "liste des acteurs", Icons.Filled.Person)

}

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val viewmodel: MainViewModel by viewModels()


        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }

            val windowSizeClass = calculateWindowSizeClass(this)

            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            val destinations = listOf(Destination.Profil, Destination.Films, Destination.Series, Destination.Acteurs)
            Scaffold(
                bottomBar = {
                    if (currentDestination?.hierarchy?.any { it.route == Destination.Profil.destination } == false) {
                        BottomNavigation {
                            destinations.forEach { screen ->
                                BottomNavigationItem(
                                    icon = { Icon(screen.icon, contentDescription = null) },
                                    label = { Text(screen.label) },
                                    selected = currentDestination?.hierarchy?.any { it.route == screen.destination } == true,
                                    onClick = { navController.navigate(screen.destination) })
                            }
                        }
                    }
                }) { innerPadding ->
                NavHost(
                    navController, startDestination = Destination.Profil.destination,
                    Modifier.padding(innerPadding)
                ) {
                    composable(Destination.Profil.destination) {
                        Profil(windowSizeClass) {
                            navController.navigate(
                                "films"
                            )
                        }
                    }
                    composable(Destination.Films.destination) {
                        Films(viewmodel = viewmodel) { id ->
                            navController.navigate(
                                "DetailsFilm/${id}"
                            )
                        }
                    }
                    composable(Destination.Series.destination) {
                        Series(viewmodel = viewmodel) {
                            navController.navigate(
                                "DetailsSerie/${id}"
                            )
                        }
                    }
                    composable("DetailsFilm/{id}") { backStackEntry ->
                        val id = backStackEntry.arguments?.getString("id") ?: ""
                        DetailsFilm(viewmodel = viewmodel, id = id)
                    }
                    composable("DetailsSerie/{id}") { backStackEntry ->
                        val id = backStackEntry.arguments?.getString("id") ?: ""
                        DetailsSerie(viewmodel = viewmodel, id = id)
                    }
                    composable(Destination.Acteurs.destination) {
                        Acteurs(viewmodel = viewmodel) {
                            navController.navigate(
                                "acteurs"
                            )
                        }
                    }}
                }
            }
        }


    }



@Composable
fun Profil(windowClass: WindowSizeClass, onClick: () -> Unit) {

    when (windowClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                MonImage()
                Spacer(Modifier.height(50.dp))
                Nom()
                Infos()
                Spacer(Modifier.height(40.dp))
                Row() {
                    ImageMail()
                    Mail()
                }
                Row() {
                    ImageLinkedin()
                    Linkedin()
                }
                Spacer(Modifier.height(40.dp))
                ButNavigate(onClick, "Démarrer")
            }

        }

        else -> {
            Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
                MonImage()
                Spacer(Modifier.height(50.dp))
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Nom()
                    Infos()
                    Spacer(Modifier.height(40.dp))
                    Row() {
                        ImageMail()
                        Mail()
                    }
                    Row() {
                        ImageLinkedin()
                        Linkedin()
                    }
                    Spacer(Modifier.height(40.dp))
                    ButNavigate(onClick, "Démarrer")
                }
            }
        }
    }

}

@Composable
fun Films(viewmodel: MainViewModel, onClick: (id: String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Films")
        ListeFilms(viewModel = viewmodel, onClick)
    }
}
@Composable
fun DetailsFilm(viewmodel: MainViewModel, id: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ListeDetailsFilm(id=id, viewModel = viewmodel )
    }
}

@Composable
fun Series(viewmodel: MainViewModel, onClick: (id: String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Series")
        ListeSeries(viewModel = viewmodel, onClick)
    }
}

@Composable
fun DetailsSerie(viewmodel: MainViewModel, id: String){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ListeDetailsSeries(id=id, viewModel = viewmodel )
    }
}


@Composable
fun Acteurs(viewmodel: MainViewModel, onClick: (id: String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Acteurs")
        ListeActeurs(viewModel = viewmodel, onClick)
    }
}



@Composable
fun ButNavigate(onClick: () -> Unit, texte: String) {
    Button(
        onClick = onClick
    ) {
        Text(texte)
    }
}



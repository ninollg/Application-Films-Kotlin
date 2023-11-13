package com.ninoleliege.mmi.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ninoleliege.mmi.myapplication.ui.theme.MyApplicationTheme




class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {

                }
            }

            val windowSizeClass = calculateWindowSizeClass(this)

            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "screen") {
                composable("screen") { Screen (windowSizeClass){navController.navigate("screen2")} }
                composable("screen2") { Screen2 {navController.navigate("screen")} }
            }
        }
    }
}


@Composable
fun Screen(windowClass: WindowSizeClass, onClick:()->Unit) {

    when (windowClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
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
                ButNavigate(onClick,"Démarrer")        }

        }
        else ->{
            Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
                MonImage()
                Spacer(Modifier.height(50.dp))
                Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
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
                    ButNavigate(onClick,"Démarrer")         }
            }
        }
        }

}

@Composable
fun Screen2(onClick:()->Unit) {
    Text("Films")
    ButNavigate(onClick,"Profil")
}

@Composable
fun ButNavigate(onClick:()->Unit, texte:String) {
    Button(
        onClick = onClick
        ) {
        Text(texte)
    }
}

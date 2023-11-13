package com.ninoleliege.mmi.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp




@Composable
fun MonImage() {
    Image(
        painterResource(id = R.drawable.image_attractive),
        contentDescription = "Nino Leliege",
        Modifier
            .clip(CircleShape)
            .width(300.dp)

    )
}

@Composable
fun Nom(){
    Text(
        text = "Nino Leliege",
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun ImageMail() {
    Image(
        painterResource(id = R.drawable._244710),
        contentDescription = "logo mail",
        Modifier.width(30.dp)
    )
}

@Composable
fun Mail(){
    Text(
        text = "nino.leliege@gmail.com"
    )
}

@Composable
fun Linkedin(){
    Text(
        text = "www.linkedin.com/in/nino-leliege-36394b227"
    )
}

@Composable
fun ImageLinkedin() {
    Image(
        painterResource(id = R.drawable.logolinkedin),
        contentDescription = "logo linkedin",
        Modifier.width(30.dp)
    )
}

@Composable
fun Infos(){
    Text(
        text = "Etudiant en 3e année de MMI à Castres"
    )
}

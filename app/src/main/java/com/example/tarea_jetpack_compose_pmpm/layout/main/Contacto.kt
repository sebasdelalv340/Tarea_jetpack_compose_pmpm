package com.example.tarea_jetpack_compose_pmpm.layout.main

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tarea_jetpack_compose_pmpm.navigation.AppScreen
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Contacto(nameResource: Int, navController: NavController) {
    val currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))
    val nombreContacto = stringResource(id=nameResource)
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .clickable {navController.navigate(route = AppScreen.SecondScreen.route + "/$nombreContacto")},
        verticalAlignment = Alignment.CenterVertically)
    {
        Icon(imageVector = Icons.Default.Person,
            tint = Color.White,
            contentDescription = "Contacto",
            modifier = Modifier.weight(0.2f))
        Spacer(modifier = Modifier.weight(0.01f))
        Column(
            modifier = Modifier.weight(1f).padding(5.dp),
            verticalArrangement = Arrangement.Center
        )
        {
            Text(
                text = nombreContacto,
                color =  Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            Text(
                text = "¿Cómo te va la asignatura de Programación Móvil?",
                color =  Color.LightGray,
                fontSize = 12.sp
            )
        }
        Spacer(modifier = Modifier.weight(0.1f))
        Text(
            text = currentTime,
            fontSize = 12.sp,
            modifier = Modifier.padding(end = 20.dp),
            color = Color.LightGray,
        )
    }
    DivisorHorizontal(1)
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyContactos(contactos: MutableList<Int>, navController: NavController) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 40.dp))
    {
        items(contactos) { id ->
            Contacto(nameResource = id, navController)
        }
    }
}
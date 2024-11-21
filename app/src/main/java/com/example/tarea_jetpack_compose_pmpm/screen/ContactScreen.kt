package com.example.tarea_jetpack_compose_pmpm.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.tarea_jetpack_compose_pmpm.layout.contacto.MyContactLayout

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SecondScreen(modifier: Modifier, navController: NavController, texto: String?) {
    SecondBody(modifier, navController, texto)
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SecondBody(modifier: Modifier, navController: NavController, texto: String?) {
    MyContactLayout(modifier, navController, texto)
}
package com.example.tarea_jetpack_compose_pmpm.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.tarea_jetpack_compose_pmpm.layout.main.MyWhatsApp


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FirstScreen(modifier: Modifier, navController: NavController) {
    FirstBody(modifier, navController)
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FirstBody(modifier: Modifier, navController: NavController) {
    MyWhatsApp(modifier, navController)
}